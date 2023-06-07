package ProxyPattern;

public class Main {
    public static void main(String[] args) {
        String book = "The Man Who Knew Infinity";
        BookParser bookParser = new BookParserImp(book);
        System.out.println(bookParser.getWordCount());
        // with proxy
        BookParser parser = new BookParserProxy(book);
        System.out.println(parser.getWordCount());
        System.out.println(parser.getWordCount());
    }
}

interface BookParser {
    int getWordCount();
}

class BookParserImp implements BookParser {
    String book;
    BookParserImp(String book){
        this.book = book;
    }
    @Override
    public int getWordCount() {
        String[] words = book.split(" ");
        return words.length;
    }
}

// Proxy
class BookParserProxy implements BookParser {
    BookParser parser;
    String book;

    BookParserProxy(String book) {
        this.book =  book;
    }

    @Override
    public int getWordCount() {
        if (parser == null) {
            System.out.println("created...");
            this.parser = new BookParserImp(this.book);
        }
        return this.parser.getWordCount();
    }
}