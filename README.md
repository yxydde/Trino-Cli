# Trino-Cli
Parameterized SQL in Trino on Trino Cli

# Requirements
* Mac OS X or Linux
* Java 8 Update 92 or higher (8u92+), 64-bit
* Maven 3.3.9+ (for building)

# Usage

```
$ cat test.sql
select  count(1) from test_tb where day = ${yesterday}
$ ./trino-cli-1.0-executable.jar --server host:8080 -f test.sql -d yesterday=$yesterday
$ ./trino-cli-1.0-executable.jar -h
Trino command line interface

USAGE:

trino [-h] [--debug] [--disable-compression] [--external-authentication] [--ignore-errors] [--insecure]
      [--krb5-disable-remote-service-hostname-canonicalization] [--password] [--[no-]progress] [--use-system-truststore] [--version]
      [--access-token=<token>] [--catalog=<catalog>] [--client-info=<info>] [--client-request-timeout=<timeout>] [--client-tags=<tags>]
      [--editing-mode=<editing-mode>] [--execute=<execute>] [-f=<file>] [--http-proxy=<proxy>] [--keystore-password=<password>] [--keystore-path=<path>]
      [--keystore-type=<type>] [--krb5-config-path=<path>] [--krb5-credential-cache-path=<path>] [--krb5-keytab-path=<path>] [--krb5-principal=<principal>]
      [--krb5-remote-service-name=<name>] [--krb5-service-principal-pattern=<pattern>] [--network-logging=<level>] [--output-format=<format>]
      [--schema=<schema>] [--server=<server>] [--session-user=<user>] [--socks-proxy=<proxy>] [--source=<source>] [--timezone=<timezone>]
      [--trace-token=<token>] [--truststore-password=<password>] [--truststore-path=<path>] [--truststore-type=<type>] [--user=<user>]
      [--external-authentication-redirect-handler=<externalAuthenticationRedirectHandler>]... [--extra-credential=<credential>]...
      [--resource-estimate=<estimate>]... [--session=<session>]...

OPTIONS:
      --access-token=<token> Access token
      --catalog=<catalog>    Default catalog
      --client-info=<info>   Extra information about client making query
      --client-request-timeout=<timeout>
                             Client request timeout (default: 2m)
      --client-tags=<tags>   Client tags
      --debug                Enable debug information
      --disable-compression  Disable compression of query results
      --editing-mode=<editing-mode>
                             Editing mode [EMACS, VI] (default: EMACS)
      --execute=<execute>    Execute specified statements and exit
      --external-authentication
                             Enable external authentication
      --external-authentication-redirect-handler=<externalAuthenticationRedirectHandler>
                             External authentication redirect handlers: DESKTOP_OPEN, SYSTEM_OPEN, PRINT, OPEN, ALL (default: ALL)
      --extra-credential=<credential>
                             Extra credentials (property can be used multiple times; format is key=value)
  -f, --file=<file>          Execute statements from file and exit
  -h, --help                 Show this help message and exit
      --http-proxy=<proxy>   HTTP proxy to use for server connections
      --ignore-errors        Continue processing in batch mode when an error occurs (default is to exit immediately)
      --insecure             Skip validation of HTTP server certificates (should only be used for debugging)
      --keystore-password=<password>
                             Keystore password
      --keystore-path=<path> Keystore path
      --keystore-type=<type> Keystore type
      --krb5-config-path=<path>
                             Kerberos config file path (default: /etc/krb5.conf)
      --krb5-credential-cache-path=<path>
                             Kerberos credential cache path
      --krb5-disable-remote-service-hostname-canonicalization
                             Disable service hostname canonicalization using the DNS reverse lookup
      --krb5-keytab-path=<path>
                             Kerberos key table path (default: /etc/krb5.keytab)
      --krb5-principal=<principal>
                             Kerberos principal to be used
      --krb5-remote-service-name=<name>
                             Remote peer's kerberos service name
      --krb5-service-principal-pattern=<pattern>
                             Remote kerberos service principal pattern (default: ${SERVICE}@${HOST})
      --network-logging=<level>
                             Network logging level [NONE, BASIC, HEADERS, BODY] (default: NONE)
      --output-format=<format>
                             Output format for batch mode [ALIGNED, VERTICAL, TSV, TSV_HEADER, CSV, CSV_HEADER, CSV_UNQUOTED, CSV_HEADER_UNQUOTED, JSON,
                               NULL] (default: CSV)
      --password             Prompt for password
      --[no-]progress        Show query progress
      --resource-estimate=<estimate>
                             Resource estimate (property can be used multiple times; format is key=value)
      --schema=<schema>      Default schema
      --server=<server>      Trino server location (default: localhost:8080)
      --session=<session>    Session property (property can be used multiple times; format is key=value; use 'SHOW SESSION' to see available properties)
      --session-user=<user>  Username to impersonate
      --socks-proxy=<proxy>  SOCKS proxy to use for server connections
      --source=<source>      Name of source making query (default: trino-cli)
      --timezone=<timezone>  Session time zone (default: Asia/Shanghai)
      --trace-token=<token>  Trace token
      --truststore-password=<password>
                             Truststore password
      --truststore-path=<path>
                             Truststore path
      --truststore-type=<type>
                             Truststore type
      --use-system-truststore
                             Use default system (OS) truststore
      --user=<user>          Username (default: yxy)
      --version              Print version information and exit
      -d <key=value>         Variable subsitution to apply to trino commands. e.g. -d A=B
```
