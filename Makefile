filename = Main

all: compile run clean

compile:
	javac  $(filename).java

run:
	java  $(filename)

clean:
	rm *.class
