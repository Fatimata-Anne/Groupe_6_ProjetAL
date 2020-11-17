@extends('layouts.app')

@section('content')
    @if(session()->has('info'))
        <div class="notification is-success">
            {{ session('info') }}
        </div>
    @endif
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">Liste des articles</div>
                                
                                
                <div class="card-body">
                <div class="table-responsive">
                @if ($message = Session::get('success'))
                    <div class="alert alert-success">
                    <p>{{ $message }}</p>
                    </div>
                @endif
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Titre</th>
                                <th>Description</th>
                                <th>Categorie</th>
                                <td colspan = 2 style="text-align: center;">Actions</td>
                            </tr>
                        </thead>
                        
                        <tbody>
                         @foreach($articles  as $article)
                            <tr style="text-align: center;" >
                                <td>{{$article->titre}}</td>
                                <td>{{$article->description}} </td>
                                <td>{{ $article->categorie ? $article->categorie->name : '' }} </td>  
                                 <td>   
                                    <a href="{{route('articles.edit',$article->id)}}" style="color: #FFC107;" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                    
                                    <form  action="{{route('articles.destroy',$article->id)}}" method="POST" class="d-inline">
                                        @csrf
                                        @method('Delete')
                                        <button type="submit" style="color: #E34724;" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></button>
                                    </form>
                                   
                                </td>   
                                
                            </tr>
                            @endforeach
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
{!! $articles->links() !!}
@endsection