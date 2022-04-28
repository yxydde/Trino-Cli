# Presto-CLI
Parameterized SQL in Presto on Presto CLI

# Requirements
* Mac OS X or Linux
* Java 8 Update 92 or higher (8u92+), 64-bit
* Maven 3.3.9+ (for building)

# Usage

```
$ cat test.sql
select  count(1) from test_tb where day = ${yesterday}
$ bin/presto-cli.sh  --server host:8080 -f test.sql -d yesterday=$yesterday
$ bin/presto-cli.sh --help
NAME
        presto - Presto interactive console

SYNOPSIS
        presto [--catalog <catalog>]
                [--client-request-timeout <client request timeout>]
                [--client-tags <client tags>] [--debug] [--enable-authentication]
                [--execute <execute>] [(-f <file> | --file <file>)] [(-h | --help)]
                [--http-proxy <http-proxy>] [--keystore-password <keystore password>]
                [--keystore-path <keystore path>]
                [--krb5-config-path <krb5 config path>]
                [--krb5-credential-cache-path <krb5 credential cache path>]
                [--krb5-disable-remote-service-hostname-canonicalization]
                [--krb5-keytab-path <krb5 keytab path>]
                [--krb5-principal <krb5 principal>]
                [--krb5-remote-service-name <krb5 remote service name>]
                [--log-levels-file <log levels file>] [--output-format <output-format>]
                [--password] [--schema <schema>] [--server <server>]
                [--session <session>...] [--socks-proxy <socks-proxy>]
                [--source <source>] [--truststore-password <truststore password>]
                [--truststore-path <truststore path>] [--user <user>] [--version]

OPTIONS
        --catalog <catalog>
            Default catalog

        --client-request-timeout <client request timeout>
            Client request timeout (default: 2m)

        --client-tags <client tags>
            Client tags

        --debug
            Enable debug information

        --enable-authentication
            Enable client authentication

        --execute <execute>
            Execute specified statements and exit

        -f <file>, --file <file>
            Execute statements from file and exit

        -h, --help
            Display help information

        --http-proxy <http-proxy>
            HTTP proxy to use for server connections

        --keystore-password <keystore password>
            Keystore password

        --keystore-path <keystore path>
            Keystore path

        --krb5-config-path <krb5 config path>
            Kerberos config file path (default: /etc/krb5.conf)

        --krb5-credential-cache-path <krb5 credential cache path>
            Kerberos credential cache path

        --krb5-disable-remote-service-hostname-canonicalization
            Disable service hostname canonicalization using the DNS reverse
            lookup

        --krb5-keytab-path <krb5 keytab path>
            Kerberos key table path (default: /etc/krb5.keytab)

        --krb5-principal <krb5 principal>
            Kerberos principal to be used

        --krb5-remote-service-name <krb5 remote service name>
            Remote peer's kerberos service name

        --log-levels-file <log levels file>
            Configure log levels for debugging using this file

        --output-format <output-format>
            Output format for batch mode [ALIGNED, VERTICAL, CSV, TSV,
            CSV_HEADER, TSV_HEADER, NULL] (default: CSV)

        --password
            Prompt for password

        --schema <schema>
            Default schema

        --server <server>
            Presto server location (default: localhost:8080)

        --session <session>
            Session property (property can be used multiple times; format is
            key=value; use 'SHOW SESSION' to see available properties)

        --socks-proxy <socks-proxy>
            SOCKS proxy to use for server connections

        --source <source>
            Name of source making query

        --truststore-password <truststore password>
            Truststore password

        --truststore-path <truststore path>
            Truststore path

        --user <user>
            Username

        --version
            Display version information and exit


	-d <key=value>  Variable subsitution to apply to presto-cli commands. e.g. -d A=B
```
