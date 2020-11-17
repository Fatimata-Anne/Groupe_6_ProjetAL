@extends('template')
@section('contenu')

<div class="col-sm-offset-4 col-sm-4" id="exampleModal">
        <br>
        <div class="panel panel-success">   
            <div class="panel-heading">Detail Article</div>
            <div class="panel-body"> 
                <p>Titre : {{$article->titre}}</p>
                <p>Desciption : {{ $article->description }}</p>
            </div>
        </div>              
        <a href="javascript:history.back()" class="btn btn-success">
            <span class="glyphicon glyphicon-circle-arrow-left"></span> Retour
        </a>
    </div>
@endsection