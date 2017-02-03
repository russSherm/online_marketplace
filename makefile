JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
        $(JC) $(JFLAGS) $*.java

CLASSES = \
        MarketplaceServer.java \
        CustomerController.java \
        CustomerView.java \
        AdminController.java \
        AdminView.java \
        MarketplaceModel.java \
        MarketplaceApp.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
        $(RM) *.class