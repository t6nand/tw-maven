# To only show maven error logs and suppress rest, use flag '-q'.
# To run project in debugging mode, use flag '-X'
echo "Loading tw-maven project....."
mvn clean install exec:java -Dexec.mainClass="Main" -q
