import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.css']
})
export class CategoryEditComponent implements OnInit {

  categoryForm: FormGroup;
  id: number;

  constructor(private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute) {
    // this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
    //   this.id = +paramMap.get('id');
    //   const category = this.getCategory(this.id);
    //   this.categoryForm = new FormGroup({
    //     id: new FormControl(category.id),
    //     name: new FormControl(category.name),
    //   });
    // });
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getCategory(this.id);
    });
  }

  ngOnInit(): void {
  }

  getCategory(id: number) {
    // return this.categoryService.findById(id);
    return this.categoryService.findById(id).subscribe(category => {
      this.categoryForm = new FormGroup({
        name: new FormControl(category.name),
      });
    });
  }

  updateCategory(id: number) {
  //   const category = this.categoryForm.value;
  //   this.categoryService.updateCategory(id, category);
  //   alert('Cập nhật thành công');

    const category = this.categoryForm.value;
    this.categoryService.updateCategory(id, category).subscribe(() => {
      alert('Cập nhật thành công');
    }, e => {
      console.log(e);
    });
  }
}