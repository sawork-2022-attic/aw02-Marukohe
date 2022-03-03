package com.example.poshell.cli;

import com.example.poshell.biz.PosService;
import com.example.poshell.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class PosCommand {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @ShellMethod(value = "List Products", key = "p")
    public String products() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Product product : posService.products()) {
            stringBuilder.append("\t").append(++i).append("\t").append(product).append("\n");
        }
        return stringBuilder.toString();
    }

    @ShellMethod(value = "New Cart or Empty an Existing Cart", key = "n")
    public String newCart() {
        return posService.newCart() + " OK";
    }

    @ShellMethod(value = "Add a Product to Cart", key = "a")
    public String addToCart(String productId, int amount) {
        if (posService.add(productId, amount)) {
            return posService.getCart().toString();
        }
        return "ERROR";
    }

    @ShellMethod(value = "List Products in Cart", key = "l")
    public String listCart() {
        if (posService.getCart() != null) {
            return posService.getCart().toString();
        }
        return "NO CART NOW";
    }

    @ShellMethod(value = "Modify the amount of a Product", key = "m")
    public String modifyProduct(String productId, int amount) {
        if (posService.getCart() == null) {
            return "NO CART NOW";
        }

        if (posService.add(productId, amount)) {
            return posService.getCart().toString();
        }
        return "ERROR";
    }

    @ShellMethod(value = "Delete a Product in Cart", key = "r")
    public String deleteProduct(String productId) {
        if (posService.getCart() == null) {
            return "NO CART NOW";
        }

        if (posService.remove(productId)) {
            return posService.getCart().toString();
        }
        return "ERROR";
    }
}
