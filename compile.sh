find . -name '*.java' > sources.txt
javac -sourcepath 'dirname $0' @sources.txt
java srcs.Main Scenario/Sample1.txt

# javac -sourcepath .:/Users/jichen-m/Avaj-Launcher @sources.txt
# javac @sources.txt
