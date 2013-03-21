

LYD.getObject = function(movieName){
    if (navigator.appName.indexOf("Microsoft") != -1) {  
        return window[movieName];  
    } else {  
        return document[movieName];  
  }  
}