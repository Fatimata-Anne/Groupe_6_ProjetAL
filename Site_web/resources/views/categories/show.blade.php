@extends('template')
@section('contenu')

<div class="col-sm-offset-4 col-sm-4" id="exampleModal">
        <br>
        <div class="panel panel-success">   
            <div class="panel-heading">{{$categorie->name}}</div>
            <div class="panel-body"> 
                @foreach($articles as $article)
                <a href="{{route('articles.show',$article->id)}}">Titre : {{$article->titre}}</a></br>
                @endforeach
            </div>
        </div>              
        <a href="javascript:history.back()" class="btn btn-success">
            <span class="glyphicon glyphicon-circle-arrow-left"></span> Retour
        </a>
    </div>
@endsection