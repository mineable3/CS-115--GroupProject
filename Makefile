filename = Main

all: compile run

compile:
	javac $(filename).java

run:
	java $(filename)

clean:
	rm $(filename).class
