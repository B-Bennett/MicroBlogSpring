package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by BennettIronYard on 11/9/15.
 */
@Controller
public class MicroBlogController {
    @Autowired
    MessageRepository messages;
    //ArrayList<Message> messages = new ArrayList(); //Create an ArrayList<Message> in your controller to store submitted messages

    //You will always be calling a string

    @RequestMapping("/")
    public String home(Model model, HttpServletRequest request) { //It should take the model and the request as arguments
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");//you have to cast (String)... //It should read the username from the session and add it to the model
        model.addAttribute("username", username);
        model.addAttribute("messages", messages.findAll());
        return "home"; //It should return the home template
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, String username) { //It should take the request and the username as arguments
        HttpSession session = request.getSession();
        session.setAttribute("username", username); //It should save the username to the session
        return "redirect:/"; //It should return a redirect to /
    }

    @RequestMapping("/add-message")
    public String addMessages(String text) { //It should take the message text as an argument
        Message message = new Message();    //(messages.size() + 1, text);
        message.text = text; //or msgtext
        messages.save(message); //It should create a Message object and add it to the arraylist
        return "redirect:/"; //It should return a redirect to /
    }
    @RequestMapping("/delete-message")
    public String id(Integer id) {  //It should take the message id as an argument (the type should be Integer)
        messages.delete(id);
        //int i = 1;
        /*for (Message message : messages) {  // not needed for databases... important for array lists.
            message.id = i;
            i++;
        }
        */
        return "redirect:/";     //It should return a redirect to
    }
    @RequestMapping("/edit-message")
    public String editmessage(Integer id, String text) {
        Message message = messages.findOne(id);
        message.text = text;
        messages.save(message);
        return "redirect:/";

    }

}
