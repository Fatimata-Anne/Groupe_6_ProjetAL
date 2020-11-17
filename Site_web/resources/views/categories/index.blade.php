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
                <div class="card-header">Liste des categories</div>
                                
                                
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
                                <th>#</th>
                                <th>Nom</th>
                                <td colspan = 2 style="text-align: center;">Actions</td>
                            </tr>
                        </thead>
                        
                        <tbody>
                         @foreach($categories  as $categorie)
                            <tr style="text-align: center;" >
                                <td  >{{$categorie->id}}</td>
                                <td>{{$categorie->name}} </td>
                                <td>
                                    
                                    <a href="{{route('categories.edit',$categorie->id)}}" style="color: #FFC107;" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                    
                                    <form  action="{{route('categories.destroy',$categorie->id)}}" method="POST" class="d-inline">
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
{!! $categories->links() !!}
@endsection