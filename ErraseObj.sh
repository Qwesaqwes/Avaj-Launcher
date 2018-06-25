find . -name '*.class' > sourcesClass.txt
cat sourcesClass.txt | xargs rm
rm sourcesClass.txt
rm sources.txt
rm Simulation.txt
