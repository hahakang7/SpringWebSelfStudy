package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }


    @GetMapping("/{itemId}")
    public String itemId(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

//    @PostMapping("/add")
//    public String addItemV1(@RequestParam String itemName,
//                       @RequestParam Integer price,
//                       @RequestParam Integer quantity,
//                       Model model
//                       ) {
//        Item item = new Item(itemName, price, quantity);
//        itemRepository.save(item);
//        model.addAttribute("item", item);
//        return "/basic/item";
//    }

//    @PostMapping("/add")
//    public String addItemV2(@ModelAttribute("item") Item item, Model model) {
//        itemRepository.save(item);
//        //자동 추가되므로 생략 가능
////        model.addAttribute("item", item);
//        return "/basic/item";
//    }

//    @PostMapping("/add")
//    public String addItemV3(@ModelAttribute Item item) {
//        itemRepository.save(item);
//        //모델 애트리뷰트의 이름을 생략한 경우에는 클래스명의 첫글자를 소문자로 만든 객체가 모델에 자동으로 담긴다
////        model.addAttribute("item", item);
//        return "/basic/item";
//    }

//    @PostMapping("/add")
//    public String addItemV4(Item item) {
//        itemRepository.save(item);
//        //ModelAttribute도 생략가능
////        model.addAttribute("item", item);
//        return "basic/item";
//    }

    /**
     * PRG - Post/Redirect/Get
     */
//    @PostMapping("/add")
//    public String addItemV5(Item item) {
//        itemRepository.save(item);
//        return "redirect:/basic/items/" + item.getId();
//    }

    @PostMapping("/add")
    public String addItemV6(Item item, RedirectAttributes redirectAttributes) {
        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", "true");
        //이름중요!!!
        //model.addAttribute("item", savedItem);
        //return "/basic/items";
        return "redirect:/basic/items/{itemId}";
    }


    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String editForm(@PathVariable long itemId, @ModelAttribute Item item) {
        itemRepository.update(itemId, item);
        return "redirect:/basic/items/{itemId}";
    }

    /*
    테스트용 데이터
     */
    @PostConstruct
    public void init() {

        itemRepository.save(new Item("itemA", 100000, 10));
        itemRepository.save(new Item("itemB", 130000, 16));
    }

}
