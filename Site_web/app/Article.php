<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Article extends Model
{

    protected $table = 'articles';

    protected $fillable = ['id',
        'titre', 'description', 'categorie_id','created_at','updated_at'
    ];

    public function categorie()
    {
        return $this->belongsTo('App\Categorie');
    }
}
