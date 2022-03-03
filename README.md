# POS in Shell

**asciinema**  
https://asciinema.org/a/NcPCYVJAufHljxG2kmiHik1mT

To run
```shell
mvn clean spring-boot:run
```

**分层设计**  
biz：是Business Logic Layer，用于实现具体的指令效果并检查数据合法性，是连接Presentation Layer和ata Access Layer的纽带；  
cli：是Presentation Layer，用于跟用户交互，介绍用户输入的指令并展示用户想要获得的数据；  
db：是Data Access Layer，用于存储系统内的数据，这里将数据存储在了内存中，也可以接入一个数据库保存数据。  

**指令介绍**  
a: Add a Product to Cart  
l: List Products in Cart  
m: Modify the amount of a Product  
n: New Cart or Empty an Existing Cart 
p: List Products  
r: Delete a Product in Cart  
  
The demo shows a simple POS system with command line interface. Currently it implements three commands which you can see using the `help` command.

```shell
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.5.7)
 
shell:>help
AVAILABLE COMMANDS

Built-In Commands
        clear: Clear the shell screen.
        exit, quit: Exit the shell.
        help: Display help about available commands.
        history: Display or save the history of previously run commands
        script: Read and execute commands from a file.
        stacktrace: Display the full stacktrace of the last error.

Pos Command
        a: Add a Product to Cart
        n: New Cart
        p: List Products
```

Everytime a customer come to make a purchase, use `n` to create a new cart and then use `a ${productid} ${amount}` to add a product to the cart.

Please make the POS system robust and fully functional by implementing more commands, for instance, print/empty/modify cart.

Implementing a PosDB with real database is very much welcome. 

Please elaborate your understanding in layered systems via this homework in your README.md.