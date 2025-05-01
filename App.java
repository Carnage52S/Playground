public class App {
    public static void main(String[] args) {

        WeddingParty weddingParty = new WeddingParty();
        
        weddingParty.addGroom("Ryan");
        weddingParty.addBride("Beth");
        weddingParty.addBestMan("Umair");
        weddingParty.addGroomsman("Smiley");
        weddingParty.addGroomsman("Beavers");
        weddingParty.addMaidOfHonor("Amanda");
        weddingParty.addBridesmaid("Dana");
        weddingParty.addBridesmaid("Katie");

        println("Groom: " + weddingParty.getGroom());
        println("Bride: " + weddingParty.getBride());
        println("Wedding Party: " + weddingParty.getWeddingParty());
    }
}
