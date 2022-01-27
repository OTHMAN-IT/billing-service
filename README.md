Les étapes de création d'un micro service (Billing Service):
------------------------------

Création classe "Bill.java" avec les attributs nécessaires +  les annotations nécessaires JPA(@Entity @Data @AllArgsConstructor @NoArgsConstructor @ToString).
Création classe "ProductItem.java" avec les attributs nécessaires +  les annotations nécessaires JPA(@Entity @Data @AllArgsConstructor @NoArgsConstructor @ToString).

------------------------------
Création du Repository "BillRepository.java" qui heritera de l'interface JpaRepositroy + l'annotation (@RepositoryRestResource).
Création du Repository "ProductItemRepository.java" qui heritera de l'interface JpaRepositroy + l'annotation (@RepositoryRestResource).
@RepositoryRestResource crée le service HATEOAS avec Spring JPA et les opérations seront exposées au format HATEOAS.

------------------------------
Configuration application.properties où on mentionne: 
-Le port du server 8083.
-Le nom du micro service en cours , de préference en majuscule pour etre detecté par la Gateway (BILLING-SERVICE).
-La base de donnée H2 Console.
-L'activation du cloud discovery.

-------------------------------
Communication REST entre les micro-services : Declarative Rest Client avec Spring Cloud Feign

Création de deux Interfaces Open Feign "CustomerServiceClient.java" et "InventoryServiceClient.java" afin de communique avec les micro services "CUSTOMER-SERVICE" et "INVENTORY-SERVICE"
sans avoir à accéder à la base de donnée.
@FeignClient(name = "CUSTOMER-SERVICE")
@FeignClient(name = "INVENTORY-SERVICE")

Feign est un Framework, introduite dans Spring cloud, qui permet de créer facilement un Client REST d’une manière déclarative.

Le service Billing est un service de facturation qui doit absolument interagir avec les autres micro services(CUSTOMER-SERVICE & INVENTORY-SERVICE) afin de récuperer des informations.

-------------------------------
Création d'un fichier controller "BillingRestController":
-Mentionner l'annotation @RestController.
-Injecter les Repository et les services open Feign crées.
-Generer un constructeur avec parametre des injections précedentes.
-Création d'une méthode get qui fournira la facture au complet avec les informations nécessaires tout en utiliasant les repository et les services Open Feign déja crée.

-------------------------------

Création de deux models "Customer.java" et "Inventory.java" sans mentionner l'annotation de mappage relationne "@entity".
Les models doivent etre similaire avec les entités se trouvant au niveau des micro services concernés en ajoutant l'annotation @data pour les setters et les getters.

------------------------------
L'application est testé par CommandLineRunner est une interface Spring Boot simple avec une méthode run . 
Spring Boot appellera automatiquement la méthode run de tous les beans implémentant cette interface une fois le contexte de l'application chargé.

------------------------------
Les dépendances nécessaires:
-Spring web
-Spring Data JPA
-H2 DataBase
-RestRepositories
-Lombok
-Spring Boot DevTools
-Eureka Discovery Client
-Spring Boot Actuator
-OpenFeign
-Spring HATEOS

-------------------------------
![image](https://user-images.githubusercontent.com/61996048/143938795-e02fdece-28ef-475a-9a86-2d5ca641fba7.png)
