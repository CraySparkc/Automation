interface Playable{
    void play(int strings);
}
class Music {
    private final String instrument;

    public Music(String instrument) {
        this.instrument = instrument;
    }

    public String getInstrument() {
        return instrument;
    }

    public enum CountStrings{
        GUITAR (6),
        PIANO (230);
        private final int count;
        CountStrings(int count){
            this.count = count;
        }

        public int getCount() {
            return count;
        }
    }
}
class Guitar extends Music implements Playable{
    public Guitar (String instrument){
        super(instrument);
    }
    @Override
    public void play(int strings){
        System.out.println("Гитара "+this.getInstrument()+" играет на "+strings+" струнах");
    }
    public void playWithEnum(){
        play(CountStrings.GUITAR.getCount());
    }
}

class Piano extends Music implements Playable{
    public Piano (String instrument){
        super(instrument);
    }
    @Override
    public void play(int strings){
        System.out.println("Пианино "+this.getInstrument()+" играет на "+strings+" струнах");
    }
    public void playWithEnum(){
        play(CountStrings.PIANO.getCount());
    }
}