package com.hexun;

import com.facebook.presto.cli.Presto;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 */
public class App {

    private final static String F_OPT = "-f";
    private final static String D_OPT = "-d";
    private final static String FILE_OPT = "--file";
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    private static boolean debug_mode = false;

    public static void main(String[] args) throws Exception {
        String debug = System.getenv("PRESTO_CLI_DEBUG");
        if (debug != null && "true".equals(debug.trim().toLowerCase())) {
            debug_mode = true;
        }

        if (args != null && args.length > 0) {
            String[] prestoArgs = prePrestArgs(args);
            if (debug_mode) {
                soutArray(args);
                soutArray(prestoArgs);
            }
            Presto.main(prestoArgs);
            if ("-h".equals(args[0]) || "--help".equals(args[0])) {
                System.out.println("\t-d <key=value>  Variable subsitution to apply to hive commands. e.g. -d A=B");
            }

        }
    }

    private static String[] prePrestArgs(String[] args) throws IOException {
        List<String> list = Arrays.asList(args);
        Iterator<String> it = list.iterator();
        String file = null;
        Map<String, String> map = new HashMap<String, String>();
        List<String> argList = new ArrayList<String>();
        int file_idx = 0;
        while (it.hasNext()) {
            String param = it.next();
            //剔除 -d 选项及参数
            if (D_OPT.equals(param.trim())) {
                if (it.hasNext()) {
                    String[] kv = it.next().split("=");
                    map.put(kv[0], kv[1]);
                }
                continue;
            }
            argList.add(param);
            if (F_OPT.equals(param.trim()) || FILE_OPT.equals(param.trim())) {
                if (it.hasNext()) {
                    file = it.next();
                    argList.add(file);
                    file_idx = argList.size() - 1;
                }
            }
        }

        if (file != null) {
            String newFile = generateSqlScript(file, map);
            argList.set(file_idx, newFile);
        }

        String[] presto_args = new String[argList.size()];

        for (int i = 0; i < argList.size(); i++) {
            presto_args[i] = argList.get(i);
        }
        return presto_args;
    }

    private static String generateSqlScript(String filePath, Map<String, String> map) throws IOException {
        StringBuilder strBuilder = new StringBuilder();
        File inFile = new File(filePath);
        List<String> lines = IOUtils.readLines(new FileInputStream(inFile));
        for (String line : lines) {
            if (line.trim().startsWith("#") || line.trim().startsWith("--")) {
                continue;
            }
            strBuilder.append(line).append("\r\n");
        }
        String content = strBuilder.toString();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Pattern pattern = Pattern.compile("\\$\\{\\s*" + entry.getKey() + "\\s*\\}");
                Matcher m = pattern.matcher(content);
                content = m.replaceAll(entry.getValue());
            }
        }
        String out = getOutPutDir() + File.separator + inFile.getName();
        IOUtils.write(content, new FileOutputStream(out));
        return out;
    }

    private static String getOutPutDir() {
        String rootDir = System.getenv("PRESTO_CLI_TMP_PATH");
        if (rootDir == null || "".equals(rootDir.trim())) {
            rootDir = "/tmp";
        }
        String user_dir = System.getProperty("user.name");
        String date = dateFormat.format(new Date());
        String distDir = rootDir + File.separator + user_dir + File.separator + date;
        File file = new File(distDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        return distDir;
    }

    private static void soutArray(String[] args) {
        if (args != null && args.length > 0) {
            for (String str : args) {
                System.out.printf(str + " ");
            }
            System.out.println();
        }
    }
}
