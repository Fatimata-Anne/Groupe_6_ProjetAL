<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Laravel</title>

        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@200;600&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="/css/index.css">


        <!-- Styles -->
        <style>
            html, body {
                background-color: #fff;
                color: #636b6f;
                font-family: 'Nunito', sans-serif;
                font-weight: auto;
                height: 200vh;
                margin: 0;
            }


           

            .position-ref {
                position: relative;
            }

            .top-right {
                position: absolute;
                right: 10px;
                top: -75px;
            }



           

            .title {
                font-size: 84px;
            }

            .links > a {
                color: #636b6f;
                padding: 0 25px;
                font-size: 13px;
                font-weight: 600;
                letter-spacing: .1rem;
                text-decoration: none;
                text-transform: uppercase;
            }

            .link{
                
                font-weight: auto;
                

            }

            
        </style>
    </head>

    <body>
   
    <h1 class="top-">Blog M1GLSI</h1>
        <div class="flex-center position-ref full-height">
        
            @if (Route::has('login'))
                <div class="top-right links">
                    @auth
                        <a href="{{ url('/home') }}">Home</a>
                    @else
                        <a href="{{ route('login') }}">Login</a>

                        @if (Route::has('register'))
                            <a href="{{ route('register') }}">Register</a>
                        @endif
                    @endauth
                    
                </div>
            @endif
            
            <div class="col-md-12">
               
                    <div class="card-header" class="top-left">
                       
                       
                        <nav class="col-md-3">
                            </hr>
                            <h3>Catégories</h3>
                            @foreach ($categories as $categorie)
                            <ul>
                                <a href="{{route('categories.show',$categorie->id)}}"> <li>{{$categorie->name}}</li></a> 

                            </ul>
                            @endforeach
                        </nav>
                       
                        @foreach($articles as $article)
                        <section>
                             <p>
                             <a href="{{route('articles.show',$article->id)}}"><strong>{{$article->titre}}</strong></a><br /><br />
                                      
                            </p>	
                        </section>
                        @endforeach
                    </div>
                    
               

                
            
            </div>
        </div>    
    
    <div class="d-flex justify-content-center">
    
    </body>
   
</html>
