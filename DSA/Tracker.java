
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Expense{
    String name;
    int cost;
    LocalDate date;

    Expense(String name, int cost, LocalDate date) {
        this.name = name;
        this.cost = cost;
        this.date = date;
    }
    @Override
    public String toString() {
        return "[name=" + name + ", cost=" + cost + ", date=" + date + "]";
    }
    
}  
class ExpenseTracker{
    List<Expense> list=new ArrayList<Expense>();
    String currentFile;
    public void openFile(String fileName){
        currentFile=fileName;
        File file = new File(fileName); 
        try {
            if(file.exists()){
                loadfromfile(fileName);
                System.out.println("data loaded from the file");
            }
            else{
                file.createNewFile();
                System.out.println("new file created");
            }
            
        } catch (Exception e) {
            System.out.println("unable to open file");
        }
    }
    public void save(String fileName){
        currentFile=fileName;
        try(FileWriter writer=new FileWriter(fileName)) {
            writer.write("name,cost,date\n");
            for (Expense e : list) {
                writer.write(e.name + "," + e.cost + "," + e.date + "\n"); 
            }
            System.out.println("Data saved successfully to" + " " + fileName);
            
        } catch (IOException e) {
            System.out.println("Error while saving file");
            
        }
    }
    public void loadfromfile(String fileName){
        list.clear();    
        try(Scanner sc = new Scanner(new File(fileName))) {
            sc.nextLine();
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String [] part = line.split(",");
                String Name = part[0];
                int cost = Integer.parseInt(part[1]);
                String dat = part[2];
                LocalDate date = LocalDate.parse(dat);
                enterData(Name, cost, date);
                System.out.println("data loaded from the file");
            }
        } catch (Exception e) {
            System.out.println("unable to load file");
        }

    }
    public void enterData(String name,int cost,LocalDate date){
        Expense newEntry=new Expense(name, cost, date);
        list.add(newEntry);
    }
    public void Display(){
        int i=1;
        if(list.isEmpty()){
            System.out.println("no expenses found");
            return;
        }
        for (Expense e : list) {
            System.out.println("ID:"+i+" "+e);
            i++;
        }
    }
    public void deleteData(String name,int cost,LocalDate date){
        Boolean found=false;
        for(Expense e:list){
        if(e.name.equals(name) && e.cost==cost && e.date.equals(date)){
            found=true;
            list.remove(e);
            break;
        }
    }
        if(found==false){
            System.out.println("not found");
        }

    }
    public void searchbyname(String name){
        boolean found=false;
        for(Expense e:list){
        if(e.name.equals(name)){
            System.out.println(e);
            found=true;
        }
    }
    if(found==false){
            System.out.println("not found");
        }
    }
    public void searchbycost(int cost){
        boolean found=false;
        for(Expense e:list){
            if(e.cost==cost){
                System.out.println(e);
                found=true;
            }
        }
        if(found==false){
            System.out.println("not found");
        }
    }
    public void searchbydate(LocalDate date){
        boolean found=false;
        for(Expense e:list){
            if(e.date.equals(date)){
                found=true;
                System.out.println(e);
            }
        }
        if(found==false){
            System.out.println("not found");
        }

    }
    public void searchbyrange(LocalDate start,LocalDate end){
        boolean found=false;
        for(Expense e:list){
            if((e.date.equals(start)||e.date.isAfter(start)) && (e.date.equals(end)||e.date.isBefore(end))){
                System.out.println(e);
                found=true;
            }
        }
        if(found==false){
            System.out.println("not found");
        }
    }
    
    public void Menu(){
        System.out.println("---------------------------");
        System.out.println("EXPENSE TRACKER");
        System.out.println("---------------------------");
        System.out.println("1.enter new expense");
        System.out.println("2.Disply all expenses");
        System.out.println("3.Delete the entered data");
        System.out.println("4.search any expense");
        System.out.println("5.Exit");
        System.out.println("----------------------------");
        System.out.println("enter your choice");
    }
}  
public class Tracker {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ExpenseTracker exp=new ExpenseTracker();
        System.out.println("enter file name");
        String fileName=sc.nextLine();
        exp.openFile(fileName);
        exp.Menu();
        int option=sc.nextInt();
        while(option!=5){
        if(option==1){
            System.out.println("ENTER YOUR NEW EXPENSE DETAILS");
            System.out.println("---------------------------------");
            System.out.println("enter the name of the expense:");
            sc.nextLine();
            String name=sc.nextLine();
            System.out.println("enter the cost of expense");
            int cost=sc.nextInt();
            System.out.println("enter the date of expense");
            String in=sc.next();
            LocalDate date=LocalDate.parse(in);
            exp.enterData(name, cost, date);
            System.out.println("EXPENSE ADDED TO LIST");
            exp.Menu();
            option=sc.nextInt();
        }
        else if(option==2){
            System.out.println("EXPENSES YOU ENTERED");
            System.out.println("------------------------");
            exp.Display();
            exp.Menu();
            option=sc.nextInt();
        }
        else if(option==3){
            System.out.println("ENTER EXPENSE DETAILS TO DELETE");
            System.out.println("------------------------------------");
            System.out.println("enter the name of the expense");
            sc.nextLine();
            String name=sc.nextLine();
            System.out.println("enter cost of the expense");
            int cost=sc.nextInt();
            System.out.println("enter the date of the expense");
            String s=sc.next();
            LocalDate date=LocalDate.parse(s);
            exp.deleteData(name, cost, date);
            System.out.println("THE ABOVE GIVEN EXPENSE DELETED FROM EXPENSE LIST");
            System.out.println("------------------------------------------------------");
            exp.Menu();
            option=sc.nextInt();
        }
        else if(option==4){
            System.out.println("SELECT SEARCH OPTION");
            System.out.println("-----------------------");
            System.out.println("1.search by name");
            System.out.println("2.search by cost");
            System.out.println("3.search by date");
            System.out.println("4.search by range");
            System.out.println("5.exit");
            int op=sc.nextInt();
            if(op==1){
                System.out.println("enter name of expense");
                sc.nextLine();
                String name=sc.nextLine();
                System.out.println("following results found for:"+" "+name);
                exp.searchbyname(name);
            }
            else if(op==2){
                System.out.println("enter cost of expense");
                int cost=sc.nextInt();
                System.out.println("following results found for:"+" "+cost);
                exp.searchbycost(cost);
            }
            else if(op==3){
                System.out.println("enter date of expense");
                String a=sc.next();
                LocalDate date=LocalDate.parse(a);
                System.out.println("following results found for:"+" "+date);
                exp.searchbydate(date);
            }
            else if(op==4){
                System.out.println("enter date range");
                System.out.println("enter starting date");
                String a=sc.next();
                LocalDate start=LocalDate.parse(a);
                System.out.println("enter ending date");
                String b=sc.next();
                LocalDate end=LocalDate.parse(b);
                System.out.println("you have following expenses between"+" "+start+" "+"and"+" "+end);
                exp.searchbyrange(start, end);
            }
            else if(op==5){
                exp.Menu();
                option=sc.nextInt();
            }
            else{
                System.out.println("invalid entry");
            }
        }
        }
        exp.save(fileName);
        sc.close();
        System.out.println("thank you..!bye..!");
    }
}                                                                                            