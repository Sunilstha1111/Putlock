package Putlock;

	//import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import org.springframework.validation.BindingResult;
	
	import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;

	//import org.springframework.web.bind.annotation.RequestParam;

	import Putlock.Putlock;
	import Putlock.putRepository;

	@Controller
	@RequestMapping(path = "/food")
	
	public class PutlockController {
		
		@Autowired
		private putRepository PutRepo;
		
		@RequestMapping(value="/Info", method=RequestMethod.GET)
		public String info(Model model){
			model.addAttribute("guests",new Putlock());
			return "Info";
		}
		
		
		@RequestMapping(value = "/Info", method = RequestMethod.POST)
		public String foodTypo(@ModelAttribute Putlock guests, Model model){
			
			
			model.addAttribute(guests);
			PutRepo.save(guests);
			Iterable<Putlock> gList = PutRepo.findAll();
			model.addAttribute("guestList", gList);
			return "Summary";
		}

		@RequestMapping(value = "/delete", method = RequestMethod.GET)
		public String delete(Model model){
		     model.addAttribute("delName",new Putlock());
		     return "deleteGuest";
		}
		
		@RequestMapping(value = "/delete", method = RequestMethod.POST)
		public String deleteRow(@ModelAttribute Putlock delName, Model model){	
			
			Iterable<Putlock> deli = PutRepo.findByName(delName.getName());
			PutRepo.delete(deli);
			Iterable<Putlock> gList = PutRepo.findAll();
			model.addAttribute("guestList",gList );
			return "Summary";
			
		}
		
		      
		
	}

