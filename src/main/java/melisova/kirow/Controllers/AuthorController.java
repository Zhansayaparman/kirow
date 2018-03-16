package melisova.kirow.Controllers;

import melisova.kirow.models.Author;
import melisova.kirow.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

public class AuthorController {
    @Autowired
    private  AuthorRepository authorRepository;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("author", new Author());
        return "author_form";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/demo/all2";
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Author> allAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/all2")
    public String allAuthors2(Model model) {
        List<Author> authors = (List<Author>) authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "books";
    }

    @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
    public ModelAndView deleteBook(@RequestParam("id") long idd) {
        bookrepozitori.deleteById(idd);
        return new ModelAndView("redirect:/demo/all2");
    }
    @PostMapping("/editClient")
    public String editBook(@ModelAttribute Book book) {
        Book book11 = new Book();
        book11.setId(a);
        book11.setFirstName(book.getFirstName());
        book11.setLastName(book.getLastName());
        book11.setEmail(book.getEmail());
        bookRepository.save(book11);
        return "redirect:/demo/all2";
    }

    @RequestMapping(value = "/editBook",method = RequestMethod.GET)
    public ModelAndView editClient(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Book> book = (Optional <Book>) bookRepository.findById(id);
        model.addAttribute("book",book);
        return new ModelAndView("smp");
    }
    @RequestMapping("/editBook")
    public String showForm2(Model model){
        model.addAttribute("Book",new Book());
        return "smp";
    }
}

}
