package com.evgeniy.spring.mvc.crud.test.controllers;

import com.evgeniy.spring.mvc.crud.test.dao.PersonDAO;
import com.evgeniy.spring.mvc.crud.test.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public String all(Model model){
        // Получим всех людей из DAO и передадим их на представление(на страницу)
        model.addAttribute("people", personDAO.all());
        return "people/all";
    }

    @GetMapping("/{id}") // Введённый id в аргумент этого метода и с помощью PathVariable мы извлёчем этот id
    // и получим доступ к нему внутри этого метода
    public String searchById(@PathVariable("id") int id, Model model){
        // Получим одного человека из DAO и передадим на представление
        model.addAttribute("person", personDAO.searchById(id));
        return "people/searchById";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        // Возвращаем страницу с формой для заполениня данных нового человека
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult){ // ModelAttribute - используется для создания нового объекта класса Person
        // и добавления в него данных из формы где мы заполняем данные
        // Создание и добавление в бд нового человека
        // В BindingResult помещается ошибка если нарушаются какие-то условия валидации
        if(bindingResult.hasErrors()){ // Если есть ошибки
            return "people/new"; // то вернём ту же форму для создания человека
        }
        personDAO.save(person);
        // После того как мы добавили нашего человека в бд мы должны вернуть какую-то страницу для пользователя
        // Можем создать какую-то сраницу где будем показывать успешность операции. А так же пожем использовать
        // redirect  - который говорит браузеру перейти на какую-то другую страницу
        // В данном случае когда человек будет добавлен в бд мы отправим браузеру "redirect:/people" он перейдёт на страницу /people
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personDAO.searchById(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("id") int id){
        if(bindingResult.hasErrors()){
            return "people/edit";
        }
        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }
}
