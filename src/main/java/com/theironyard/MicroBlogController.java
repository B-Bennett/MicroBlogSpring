package com.theironyard;

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
    ArrayList<Message> messages = new ArrayList(); //Create an ArrayList<Message> in your controller to store submitted messages

    @RequestMapping("/")
    public String home(Model model, HttpServletRequest request) { //It should take the model and the request as arguments
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username"); //It should read the username from the session and add it to the model
        model.addAttribute("username", username);
        model.addAttribute("messages", messages);
        return "home"; //It should return the home template
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request, String username) { //It should take the request and the username as arguments
        HttpSession session = request.getSession();
        session.setAttribute("username", username); //It should save the username to the session
        return "redirect:/"; //It should return a redirect to /
    }

    @RequestMapping("/add-message")
    public String submittedMessages(String text) { //It should take the message text as an argument
        Message message = new Message(messages.size() + 1, text);
        messages.add(message); //It should create a Message object and add it to the arraylist
        return "redirect:/"; //It should return a redirect to /
    }
    @RequestMapping("/delete-message")
    public String id(Integer id) {  //It should take the message id as an argument (the type should be Integer)
        messages.remove(id - 1);
        int i = 1;
        for (Message message : messages) {
            message.id = i;
            i++;
        }
        return "redirect:/";     //It should return a redirect to
    }

}
