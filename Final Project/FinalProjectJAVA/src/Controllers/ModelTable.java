package Controllers;

public class ModelTable
{

    String transID, receiverID, senderID, type, amount;

    public ModelTable(String transID, String type, String receiverID, String senderID, String amount)
    {
        this.transID = transID;
        this.type = type;
        this.receiverID = receiverID;
        this.senderID = senderID;
        this.amount = amount;
    }

    public String getTransID()
    {
        return transID;
    }

    public void setTransID(String transID)
    {
        this.transID = transID;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getReceiverID()
    {
        return receiverID;
    }

    public void setReceiverID(String receiverID)
    {
        this.receiverID = receiverID;
    }

    public String getSenderID()
    {
        return senderID;
    }

    public void setSenderID(String senderID)
    {
        this.senderID = senderID;
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }


}
