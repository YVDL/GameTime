package com.vdab.services;

import com.vdab.domain.Borrower;
import com.vdab.domain.Category;
import com.vdab.domain.Game;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private Scanner scanner = new Scanner(System.in);
    private CategoryServices categoryServices = new CategoryServices();
    private GameService gameService = new GameService();
    private BorrowerService borrowerService = new BorrowerService();

    public static void main(String[] args) {

        System.out.println("Welcome to Game Time, Youri");
        Main main = new Main();
        main.showInitialOptions();

    }

    public void showInitialOptions() {
        System.out.println("Please select an option: ");
        System.out.println(
                        "0. Quit the game \n" +
                        "1. Show category for ID \n" +
                        "2. Show the fifth game \n" +
                        "3. Show the first borrower \n" +
                        "4. Show a game of your choice \n" +
                        "5. Show all games \n" +
                        "6. Show a list of games and choose a game \n" +
                        "7. Show borrowed games \n" +
                        "8. Advanced search: difficulty \n" +
                        "9. Complex search: borrowers \n" +
                        "10. New way \n" +
                        "11. Show all borrows and insert a new borrow \n" +
                        "12. Show all borrows from last month and update a borrower id \n"

                );
        int choice = scanner.nextInt();
        switch(choice){
            case 0:
                break;
            case 1:
                findCategory1();
                showInitialOptions();
                break;
            case 2:
                findFifthGame();
                showInitialOptions();
            case 3:
                findFirstBorrower();
                showInitialOptions();
            case 4:
                findGameByName();
                showInitialOptions();
            case 5:
                showAllGames();
                showInitialOptions();
            case 6:
                showAndChoose();
                showInitialOptions();
        }
    }

    private void showAndChoose() {
        showAllGames();
        System.out.println("Enter a name or part of the name of the game: ");
        Game game = gameService.showAndChoose(scanner.next().toLowerCase(Locale.ROOT));
        System.out.println(game.getGameName() + " " + game.getDifficulty().getDifficultyName() + " " + game.getCategory().getCategoryName());
    }

    private void showAllGames() {
        List<Game> gamesList = gameService.showAllGames();
        for (Game g : gamesList){
            System.out.println(g.getGameName() + " " + g.getEditor() + " " + g.getPrice());
            System.out.println("----------------------------------------------------------");
        }
    }

    public void findGameByName() {
        System.out.println("Enter a name or part of the name of the game: ");
        Game game = gameService.findGameByName(scanner.next().toLowerCase(Locale.ROOT));
        System.out.println(game.getGameName() + " " + game.getAge() + " " + game.getAuthor() + " " + game.getPrice());

    }

    private void findFirstBorrower() {
        Borrower borrower = borrowerService.findFirstBorrower();
        System.out.println(borrower.getBorrowerName() + " " + borrower.getCity());
    }

    private void findFifthGame() {
        Game game = gameService.findFifthGame();
        System.out.println(game.toString());
    }

    private void findCategory1() {
        Category category = categoryServices.findCategory1();
        System.out.println(category.getCategoryName()+ " " + category.getId() + "\n ----------------------");
    }
}
