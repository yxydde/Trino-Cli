mvn install -DskipTests
package='presto-cli'
rm -rf build/${package}/*
mkdir -p build/${package}/lib
mkdir -p build/${package}/bin
cp target/${package}*.jar build/${package}/lib/
mvn dependency:copy-dependencies -DoutputDirectory=build/${package}/lib
cp script/*.sh build/${package}/bin/
cd build/
tar -czvf ${package}.tar.gz ${package}/*
