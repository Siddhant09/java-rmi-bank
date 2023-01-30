JAVA = java
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
bank/RemoteAccount.java\
bank/AccountImpl.java\
common/Account.java\
client/AccountClient.java\
client/MenuImpl.java\
client/TransactionImpl.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) */*.class

server: 
	$(JAVA) bank.RemoteAccount

clientAccount:
	$(JAVA) client.AccountClient