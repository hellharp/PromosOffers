package com.ryggsekk.promosoffers.controller;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
 
import com.ryggsekk.promosoffers.model.Offer;
import com.ryggsekk.promosoffers.service.OfferService;
import com.ryggsekk.promosoffers.model.User;
import com.ryggsekk.promosoffers.model.UserProfile;
import com.ryggsekk.promosoffers.service.UserProfileService;
import com.ryggsekk.promosoffers.service.UserService;

@Controller
public class PromosOffersController {
    
    @Autowired
    UserProfileService userProfileService;
     
    @Autowired
    UserService userService;

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Heisann! Velkommen til v�r tilbudsside!");
        return "welcome";
    }
 
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }

    private OfferService offerService;

    @Autowired(required=true)
    @Qualifier(value="offerService")
    public void setOfferService(OfferService os){
        this.offerService = os;
    }

    @RequestMapping(value = "/offers", method = RequestMethod.GET)
    public String listOffer(Model model) {
        model.addAttribute("offer", new Offer());
        model.addAttribute("listOffers", this.offerService.listOffers());
        return "offers";
    }


    @RequestMapping(value= "/offers/add", method = RequestMethod.POST)
    public String addOffer(@ModelAttribute("offer") Offer o){

        if(o.getId() == 0){
            //new offer, add it
            this.offerService.addOffer(o);
        }else{
            //existing offer, call update
            this.offerService.updateOffer(o);
        }

        return "redirect:/offers";

    }

    @RequestMapping("/offers/remove/{id}")
    public String removeOffer(@PathVariable("id") int id){

        this.offerService.deleteOffer(id);
        return "redirect:/offers";
    }

    @RequestMapping("/offers/edit/{id}")
    public String editOffer(@PathVariable("id") int id, Model model){
        model.addAttribute("offer", this.offerService.findById(id));
        model.addAttribute("listOffers", this.offerService.listOffers());
        return "offers";
    }






 
    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "dba";
    }
 
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }
 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
 
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
    
    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "newuser";
    }
    
    /*
     * This method will be called on form submission, handling POST request It
     * also validates the user input
     */
    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String saveRegistration(@Valid User user,
            BindingResult result, ModelMap model) {
 
        if (result.hasErrors()) {
            System.out.println("There are errors");
            return "newuser";
        }
        userService.save(user);
         
        System.out.println("First Name : "+user.getFirstName());
        System.out.println("Last Name : "+user.getLastName());
        System.out.println("SSO ID : "+user.getSsoId());
        System.out.println("Password : "+user.getPassword());
        System.out.println("Email : "+user.getEmail());
        System.out.println("Checking UsrProfiles....");
        if(user.getUserProfiles()!=null){
            for(UserProfile profile : user.getUserProfiles()){
                System.out.println("Profile : "+ profile.getType());
            }
        }
         
        model.addAttribute("success", "User " + user.getFirstName() + " has been registered successfully");
        return "registrationsuccess";
    }
 
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
 
 
}