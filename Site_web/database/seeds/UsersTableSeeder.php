<?php

use Illuminate\Database\Seeder;
use App\User;
use App\Role;


class UsersTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {

        DB::statement('SET FOREIGN_KEY_CHECKS=0;');
        App\User::truncate();
        DB::statement('SET FOREIGN_KEY_CHECKS=1;');
      
    

      $admin=  User::create([
            'name' => 'admin',
            'email' => 'admin@admin.com',
            'password' => bcrypt('password')
        ]);

     

      $editeur=  User::create([
            'name' => 'editeur',
            'email' => 'editeur@editeur.com',
            'password' => bcrypt('password')
        ]);

        $adminRole = Role::where('name', 'admin')->first();
        
        $editeurRole = Role::where('name', 'editeur')->first();

        $admin->roles()->attach($adminRole);
        $editeur->roles()->attach($editeurRole);
        


    }
}
