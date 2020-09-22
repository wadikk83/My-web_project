package by.wadikk.web;

import by.wadikk.repository.model.Product;
import by.wadikk.service.ProductService;
import by.wadikk.service.filter.ProductFilterForm;
import by.wadikk.service.filter.SortFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

@Controller
public class StoreController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/store")
	public String store(@ModelAttribute("filters") ProductFilterForm filters, Model model) {
		Integer page = filters.getPage();			
		int pagenumber = (page == null ||  page <= 0) ? 0 : page-1;
		SortFilter sortFilter = new SortFilter(filters.getSort());
		//Page<Product> pageresult = productService.findArticlesByCriteria(PageRequest.of(pagenumber,9, sortFilter.getSortType()),
		//														filters.getPricelow(), filters.getPricehigh(),
		//														filters.getSize(), filters.getCategory(), filters.getBrand(), filters.getSearch());
		model.addAttribute("allCategories", productService.getAllCategories());
		model.addAttribute("itemsperpage", 9);
		return "store";
	}
	
	
	@RequestMapping("/article-detail")
	public String articleDetail(@PathParam("id") Integer id, Model model) {
		Product product = productService.findProductById(id);
		model.addAttribute("product", product);
		model.addAttribute("notEnoughStock", model.asMap().get("notEnoughStock"));
		model.addAttribute("addArticleSuccess", model.asMap().get("addArticleSuccess"));
		return "articleDetail";
	}
	

}
