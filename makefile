JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
        $(JC) $(JFLAGS) $*.java

CLASSES = \
        MarketplaceModel.java \
        CustomerController.java \
        CustomerView.java \
        AdminController.java \
        AdminView.java \
        Marketplace.java \
        MarketplaceApp.java \
        AbstractFactory.java \
        Administrators.java \
        Cart.java \
        Customers.java \
        Dispatcher.java \
        FrontController.java \
        Items.java \
        Users.java \
        UsersFactory.java \
        

default: classes

classes: $(CLASSES:.java=.class)

clean:
        $(RM) *.class