JC = javac
JFLAGS = -classpath .
JD = javadoc
JDFLAGS = -protected -splitindex -use -author -version -d ./javadoc
RM = rm
JR = java

CLASSES = \
		AbstractGraph.java \
		BFS.java \
		DFS.java \
		DijkstrasAlgorithm.java \
		Edge.java \
		Graph.java \
		ListGraph.java \
		MatrixGraph.java \
		UWclass.java \
		Main.java

all : Main.class

run : 
	$(JR) Main

classes : $(CLASSES:.java=.class)

%.class : %.java
	$(JC) $(JFLAGS) $<

doc:
	$(JD) $(JDFLAGS) *.java 

clean:
	$(RM) *.class 

cleandoc:
	$(RM) -r ./javadoc