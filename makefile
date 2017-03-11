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
        AddItem.java \
        AuthorizationException.java \
        AuthorizationInvocationHandler.java \
        BrowseItem.java \
        Clerk.java \
        Client.java \
        Initiate.java \
        PurchaseItem.java \
        RemoveItem.java \
        RequiresRole.java \
        Server.java \
        ServerImpl.java \
        ServerInterface.java \
        Session.java \
        UpdateItem.java \
        User.java \
        

default: classes

classes: $(CLASSES:.java=.class)

clean:
        $(RM) *.class