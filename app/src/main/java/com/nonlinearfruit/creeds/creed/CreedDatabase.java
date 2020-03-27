package com.nonlinearfruit.creeds.creed;

public class CreedDatabase {
    private String shema_yisrael = "Hear, O Israel: The LORD our God, the LORD is one.";
    private String confession_of_peter = "Simon Peter replied, \"You are the Christ, the Son of the living God.\"";
    private String apostles_creed =
            "I believe in God, the Father almighty, creator of heaven and earth.\n" +
            "\n" +
            "I believe in Jesus Christ, God’s only Son, our Lord, who was conceived by the Holy Spirit, born of the Virgin Mary, suffered under Pontius Pilate, was crucified, died, and was buried; he descended to the dead. On the third day he rose again; he ascended into heaven, he is seated at the right hand of the Father, and he will come to judge the living and the dead.\n" +
            "\n" +
            "I believe in the Holy Spirit, the holy catholic Church, the communion of saints, the forgiveness of sins, the resurrection of the body, and the life everlasting. Amen.";
    private String nicene_creed =
            "We believe in one God, the Father Almighty, Maker of heaven and earth, and of all things visible and invisible.\n" +
            "\n" +
            "And in one Lord Jesus Christ, the only-begotten Son of God, begotten of the Father before all worlds; God of God, Light of Light, very God of very God; begotten, not made, being of one substance with the Father, by whom all things were made.\n" +
            "\n" +
            "Who, for us men and for our salvation, came down from heaven, and was incarnate by the Holy Spirit of the virgin Mary, and was made man; and was crucified also for us under Pontius Pilate; He suffered and was buried; and the third day He rose again, according to the Scriptures; and ascended into heaven, and sits on the right hand of the Father; and He shall come again, with glory, to judge the quick and the dead; whose kingdom shall have no end.\n" +
            "\n" +
            "And we believe in the Holy Ghost, the Lord and Giver of Life; who proceeds from the Father and the Son; who with the Father and the Son together is worshipped and glorified; who spoke by the prophets.\n" +
            "\n" +
            "And we believe in one holy catholic and apostolic Church. We acknowledge one baptism for the remission of sins; and we look for the resurrection of the dead, and the life of the world to come. Amen.";
    private String chalcedonian_definition = "Therefore, following the holy fathers, we all with one accord teach men to acknowledge one and the same Son, our Lord Jesus Christ, at once complete in Godhead and complete in manhood, truly God and truly man, consisting also of a reasonable soul and body; of one substance with the Father as regards his Godhead, and at the same time of one substance with us as regards his manhood; like us in all respects, apart from sin; as regards his Godhead, begotten of the Father before the ages, but yet as regards his manhood begotten, for us men and for our salvation, of Mary the Virgin, the God-bearer; one and the same Christ, Son, Lord, Only-begotten, recognized in two natures, without confusion, without change, without division, without separation; the distinction of natures being in no way annulled by the union, but rather the characteristics of each nature being preserved and coming together to form one person and subsistence, not as parted or separated into two persons, but one and the same Son and Only-begotten God the Word, Lord Jesus Christ; even as the prophets from earliest times spoke of him, and our Lord Jesus Christ himself taught us, and the creed of the fathers has handed down to us.";
    private String athanasian_creed =
            "Whosoever will be saved, before all things it is necessary that he hold the catholic faith. Which faith unless every one do keep whole and undefiled, without doubt he shall perish everlastingly. And the catholic faith is this: that we worship one God in Trinity, and Trinity in Unity; neither confounding the Persons, nor dividing the Essence. For there is one Person of the Father; another of the Son; and another of the Holy Ghost. But the Godhead of the Father, of the Son, and of the Holy Ghost, is all one; the Glory equal, the Majesty coeternal. Such as the Father is; such is the Son; and such is the Holy Ghost. The Father uncreated; the Son uncreated; and the Holy Ghost uncreated. The Father unlimited; the Son unlimited; and the Holy Ghost unlimited. The Father eternal; the Son eternal; and the Holy Ghost eternal. And yet they are not three eternals; but one eternal. As also there are not three uncreated; nor three infinites, but one uncreated; and one infinite. So likewise the Father is Almighty; the Son Almighty; and the Holy Ghost Almighty. And yet they are not three Almighties; but one Almighty. So the Father is God; the Son is God; and the Holy Ghost is God. And yet they are not three Gods; but one God. So likewise the Father is Lord; the Son Lord; and the Holy Ghost Lord. And yet not three Lords; but one Lord. For like as we are compelled by the Christian verity; to acknowledge every Person by himself to be God and Lord; So are we forbidden by the catholic religion; to say, There are three Gods, or three Lords. The Father is made of none; neither created, nor begotten. The Son is of the Father alone; not made, nor created; but begotten. The Holy Ghost is of the Father and of the Son; neither made, nor created, nor begotten; but proceeding. So there is one Father, not three Fathers; one Son, not three Sons; one Holy Ghost, not three Holy Ghosts. And in this Trinity none is before, or after another; none is greater, or less than another. But the whole three Persons are coeternal, and coequal. So that in all things, as aforesaid; the Unity in Trinity, and the Trinity in Unity, is to be worshipped. He therefore that will be saved, let him thus think of the Trinity.\n" +
            "\n" +
            "Furthermore it is necessary to everlasting salvation; that he also believe faithfully the Incarnation of our Lord Jesus Christ. For the right Faith is, that we believe and confess; that our Lord Jesus Christ, the Son of God, is God and Man; God, of the Essence of the Father; begotten before the worlds; and Man, of the Essence of his Mother, born in the world. Perfect God; and perfect Man, of a reasonable soul and human flesh subsisting. Equal to the Father, as touching his Godhead; and inferior to the Father as touching his Manhood. Who although he is God and Man; yet he is not two, but one Christ. One; not by conversion of the Godhead into flesh; but by assumption of the Manhood by God. One altogether; not by confusion of Essence; but by unity of Person. For as the reasonable soul and flesh is one man; so God and Man is one Christ; Who suffered for our salvation; descended into hell; rose again the third day from the dead. He ascended into heaven, he sitteth on the right hand of the God the Father Almighty, from whence he will come to judge the living and the dead. At whose coming all men will rise again with their bodies; And shall give account for their own works. And they that have done good shall go into life everlasting; and they that have done evil, into everlasting fire. This is the catholic faith; which except a man believe truly and firmly, he cannot be saved.";

    public String getCreed(int creedId){
        CreedLookup lookup = CreedLookup.get(creedId);
        switch (lookup){
            case ShemaYisrael:
                return shema_yisrael;
            case ConfessionOfPeter:
                return confession_of_peter;
            case ApostlesCreed:
                return apostles_creed;
            case NiceneCreed:
                return nicene_creed;
            case ChalcedonianDefinition:
                return chalcedonian_definition;
            case AthanasianCreed:
            default:
                return athanasian_creed;
        }
    }
}
