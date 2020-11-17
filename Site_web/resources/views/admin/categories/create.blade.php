@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">Ajouter des catégories </div>
                                            
                    <div class="card-body">
                
                        <form method="post" action="{{route('categories.store')}}" role="form">   
                        @csrf 
                            <div class="form-group row">
                                <label for="name" class="col-md-6 col-form-label">{{ __('Nom') }}</label>

                                <div class="col-md-12">
                                    <input id="name" type="text" class="form-control @error('name') is-invalid @enderror" name="name" 
                                    value="{{old('name')}}"  required autocomplete="name" autofocus>

                                    @error('name')
                                        <span class="invalid-feedback" role="alert">
                                            <strong>{{ $message }}</strong>
                                        </span>
                                    @enderror
                                </div>
                            </div>
                                <div class="col-md-12 text-center">
                                <button type="submit" class="btn btn-success" style="color: green;">Ajouter</button></div>
                        </form>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
</div>    
@endsection