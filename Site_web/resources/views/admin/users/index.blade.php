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
                <div class="card-header">Liste des utilisateurs</div>
                                
                                
                <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nom</th>
                                <th>Email</th>
                                <th>Roles</th>
                                <td colspan = 2 style="text-align: center;">Actions</td>
                            </tr>
                        </thead>
                        
                        <tbody>
                         @foreach($users as $user)
                            <tr style="text-align: center;" >
                                <td  >{{$user->id}}</td>
                                <td>{{$user->name}} </td>
                                <td>{{$user->email}}</td>
                                <td>{{implode (', ',$user->roles()->get()->pluck('name')->toArray())}}</td>
                                <td>
                                    <a href=""  class="btn-floating disabled"><i class="material-icons">add</i></a>
                                    <a href="{{route('admin.users.edit',$user->id)}}" style="color: #FFC107;" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                    @can('delete-users')
                                    <form  action="{{route('admin.users.destroy',$user->id)}}" method="POST" class="d-inline">
                                        @csrf
                                        @method('Delete')
                                        <button type="submit" style="color: #E34724;" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></button>
                                    </form>
                                   @endcan
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
@endsection