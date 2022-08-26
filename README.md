
# Mercedes-Benz Controller Application
The Applications allows to the user to connect mercedes-benz API and get the vehicle information which vehicle belongs to user. 
So User can track & control the vehicle via the application.



https://user-images.githubusercontent.com/3717312/186885061-50969bdf-4f3c-4b75-972b-73c155ca734e.mp4





# Setup
### 1-)Setup Configration
Get an Developer account from MB developer page and create an API in MB developer console. [Mercedes Benz Developer Page](https://developer.mercedes-benz.com/news/our-first-experimental-api) 

Open the configuration file which is located in external library package. exLib and fill with the correct information.

<img width="800px" src="https://user-images.githubusercontent.com/3717312/136297075-88fa587b-2977-405b-b549-e9431f4dd836.jpg">

### 2-)Run The Application
You can direcly import the Spring project in your IDE and to make it run on your local machine or  you can make it run in docker Container.
cd (enter your project folder which you download and be sure the Dockerfile is exist)
open command line and type this
docker run -p8080:8080 mercedes-benz-controller:latest


```docker run -p8080:8080 mercedes-benz-controller:latest```

### 3-)Control the Vehicle
Open Car simulator in MB developer page and when you lock-unlock or close-open the doors than you will see  the door status will be changed in the application.
Also you can lock or unlock doors from application. If you click lock or unclock door on application, the door statu will be changed in car simulator too.
<img width="800px" src="https://user-images.githubusercontent.com/3717312/136298432-cf642f47-2d18-40bb-b44a-9f255b349dd6.jpg">
