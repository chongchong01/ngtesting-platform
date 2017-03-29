import {Component, ViewEncapsulation, ViewChild} from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NgModule, Pipe, OnInit, AfterViewInit }      from '@angular/core';
import { ModalDirective } from 'ng2-bootstrap';
import {GlobalState} from '../../../../global.state';

import { CONSTANT } from '../../../../utils/constant';
import { Utils } from '../../../../utils/utils';
import {ValidatorUtils} from '../../../../validator/validator.utils';
import { RouteService } from '../../../../service/route';

import { RoleService } from '../../../../service/role';

declare var jQuery;

@Component({
  selector: 'role-edit',
  encapsulation: ViewEncapsulation.None,
  styles: [require('./edit.scss')],
  template: require('./edit.html')
})
export class RoleEdit implements OnInit, AfterViewInit {
  id: number;
  model: any = {};
  projects: any[] = [];
  form: any;
  isSubmitted: boolean;
  @ViewChild('modal') modal: ModalDirective;

  constructor(private _state:GlobalState, private _routeService: RouteService, private _route: ActivatedRoute,
              private fb: FormBuilder, private roleService: RoleService) {

  }
  ngOnInit() {
    let that = this;

    that._route.params.forEach((params: Params) => {
      that.id = +params['id'];
    });

    if (that.id) {
      that.loadData();
    }
    that.buildForm();
  }
  ngAfterViewInit() {}

  buildForm(): void {
    let that = this;
    this.form = this.fb.group(
      {
        'name': [that.model.name, [Validators.required]],
        'descr': [that.model.descr, []],
        'disabled': [that.model.disabled]
      }, {}
    );

    this.form.valueChanges.subscribe(data => this.onValueChanged(data));
    this.onValueChanged();
  }
  onValueChanged(data?: any) {
    let that = this;
    that.formErrors = ValidatorUtils.genMsg(that.form, that.validateMsg, []);
  }

  formErrors = [];
  validateMsg = {
    'name': {
      'required':      '姓名不能为空'
    },
    'descr': {
    }
  };

  loadData() {
    let that = this;
    that.roleService.get(that.id).subscribe((json:any) => {
      that.model = json.data;
    });
  }

  save() {
    let that = this;

    that.roleService.save(that.model).subscribe((json:any) => {
      if (json.code == 1) {
        that.model = json.data;

        that.formErrors = ['保存成功'];
        that._routeService.navTo("/pages/admin/role/list");
      } else {
        that.formErrors = ['保存失败'];
      }
    });
  }

  delete() {
    let that = this;

    that.roleService.delete(that.model.id).subscribe((json:any) => {
      if (json.code == 1) {
        that.model = json.data;

        that.formErrors = ['删除成功'];
        that._routeService.navTo("/pages/project/list");
      } else {
        that.formErrors = ['删除失败'];
      }
    });
  }

  showModal(): void {
    this.modal.show();
  }
  onModalShow():void {
    // init jquery components if needed
  }

  hideModal(): void {
    this.modal.hide();
  }

}

