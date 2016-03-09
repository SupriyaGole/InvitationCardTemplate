#!/usr/bin/env bash
javac -cp src -d out src/PrintLabel.java && java -cp out/ PrintLabel --nameFormat firstFirst $@
