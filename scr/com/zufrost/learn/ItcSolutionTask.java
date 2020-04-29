package com.zufrost.learn;

import java.util.ArrayList;
import java.util.List;

public class ItcSolutionTask {
    public static void main(String[] args) {

        System.out.println("//*[@id='Hello']");



    }

    public List<WebElement> getSomeElements(String path) {
        if (path == null){
            throw IllegalArgumentException("getElements: illegal path (NULL)");
            path = "//*[@id='Hello']"; // 1 зачем после выброса исключения задавать путь?
                                    // 2 что значит этот путь?
        }
        WebDriverHelper wd = new WebDriverHelper(); // 3 что делает WebDriverHelper?
        List<String> result = new ArrayList<>();
        result.add(wd.getElements(path)); // список result положили элемент, находящийся по пути path

        if (result.isEmpty()){
            // не соответствие условия содержанию. если список пустой, нет смысла перебирать его элементы
            // предположительно условие должно выглядеть так: if (!result.isEmpty()) или if (result.size() > 0)

            for(WebElement element : result){
                if(element.getText() == "remove") { // пропущены {}  в которые надо взять result.remove(element);
                    // идет сравнение содержимого WebElement.getText() со строкой "remove"
                    // предположительно сравнение корректней делать через equals тогда условие должно выглядеть так
                    // предположительно сравнение корректней делать через equals тогда условие должно выглядеть так
                    result.remove(element);
                }
            }
        } else {
            return result.get(0);
            //разобраться в условии что приходит в else и если в него приходит пустой result,
            // то как мы можем вернуть не существующий нулевой элемент?
            // возможно return null
        }

        if (wd.isElementsPresent(path)) { //возможно  isElementsPresent возвращает boolean, разобраться в его ответах.
            // предположительно if (!wd.isElementsPresent(path))
            System.out.println("There aren't any elements by this path");
            return; // что мы возвращаем?
            // предположительно return null;
        }

        return result;
    }
}
