package Repository;

import model.Author;

import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static  final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        AuthorLiaison authorLiaison = new AuthorLiaison ();
        BookLiaison bookLiaison = new BookLiaison ();
//
//        List<Author> allAuthor = AuthorLiaison.findAll();
//        logger.info("All Authors : " + allAuthor);

        System.out.println("Bonjour");

    }
}
