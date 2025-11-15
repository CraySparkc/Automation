package classes;

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

