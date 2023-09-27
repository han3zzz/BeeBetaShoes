    let url = "/api/product";
    let urlcategory = "/api/category";
    let urlbrand = "/api/brand";
    let urltoe = "/api/toe";
    let urlsole = "/api/sole";
    let urlshoelace = "/api/shoelace";
    let urlheelcushion = "/api/heelcushion";
    let urlmaterial = "/api/material";
    let urlcolor = "/api/color";
    let urlsize = "/api/size";
    let urldesign = "/api/design";
var app = angular.module("myApp",[]);
    app.controller("ctrl", function ($scope, $http, $window){
        //load product
        $scope.list = [];
        $http.get(url).then(function (response){
           $scope.list = response.data;
        })
        // load category
        $scope.listCategory = [];
        $http.get(urlcategory).then(function (response){
            $scope.listCategory = response.data;
        })
        // load brand
        $scope.listBrand = [];
        $http.get(urlbrand).then(function (response){
            $scope.listBrand = response.data;
        })
        // load toe
        $scope.listToe = [];
        $http.get(urltoe).then(function (response){
            $scope.listToe = response.data;
        })
        // load sole
        $scope.listSole = [];
        $http.get(urlsole).then(function (response){
            $scope.listSole = response.data;
        })
        // load shoelace
        $scope.listShoelace = [];
        $http.get(urlshoelace).then(function (response){
            $scope.listShoelace = response.data;
        })
        // load heelcushion
        $scope.listHeelcushion = [];
        $http.get(urlheelcushion).then(function (response){
            $scope.listHeelcushion = response.data;
        })
        // load material
        $scope.listMaterial = [];
        $http.get(urlmaterial).then(function (response){
            $scope.listMaterial = response.data;
        })
        // load color
        $scope.listColor = [];
        $http.get(urlcolor).then(function (response){
            $scope.listColor = response.data;
        })
        // load size
        $scope.listSize = [];
        $http.get(urlsize).then(function (response){
            $scope.listSize = response.data;
        })
        // load design
        $scope.listDesign = [];
        $http.get(urldesign).then(function (response){
            $scope.listDesign = response.data;
        })
        // load size by color and quantity
        $scope.checkbox = function(mausac) {
            let listColor =  $scope.listColor;
            let listSize =  $scope.listSize;
            // Get the checkbox
            var checkBox = document.getElementById('Color'+mausac);
            // Get the output text
            var text = document.getElementById("text" + mausac);
            // If the checkbox is checked, display the output text
            for(let i = 0 ; i < listColor.length; i++){
                if (listColor[i].id === mausac){
                    if (checkBox.checked == true){
                        text.innerHTML += '<div ><label>Số lượng '+ listColor[i].name +'</label>';
                        for(let j = 0 ; j < listSize.length; j++){
                            text.innerHTML += '<span style="padding-left: 10px; padding-bottom: 10px">Size</span> '+listSize[j].name+' <input id="Color'+listColor[i].id+'Size'+listSize[j].id+'" type="number" value="0" style="width: 50px">';
                        }
                        text.innerHTML += '</div>';
                    } else {
                        text.innerHTML = '';
                    }
                }
            }

        };

        $scope.form = {};
        $scope.reset = function (){
            $scope.form = {};
        }
        //add product
        $scope.add = function(){
            var MainImage = document.getElementById("fileUpload").files;
            if (MainImage.length == 0){
                Swal.fire('Vui lòng thêm ảnh đại diện cho sản phẩm !', '', 'error');
                return;
            }
            $http.post("/api/sanpham",{
                code : $scope.form.product.code,
                name : $scope.form.product.name,
                description : $scope.form.description,
            }).then(function (product){
                if (product.status === 200){
                    //add image

                    var img = new FormData();
                    img.append("files",MainImage[0]);
                    $http.post("/api/upload",img,{
                        transformRequest: angular.identity,
                        headers: {
                            'Content-Type': undefined
                        }
                    }).then(function (upImage){
                        $http.post("/api/image",{
                            url : upImage.data[0],
                            mainImage : true,
                            idProduct : product.data.id
                        }).then(function (image){
                            var ListImage = document.getElementById("fileList").files;
                                if (ListImage.length > 0){
                                    var img1 = new FormData();
                                    for (let i = 0; i < ListImage.length; i++) {
                                        img1.append("files",ListImage[i]);
                                        $http.post("/api/upload",img1,{
                                            transformRequest: angular.identity,
                                            headers: {
                                                'Content-Type': undefined
                                            }
                                        }).then(function (imagelist){
                                               $http.post("/api/image",{
                                                   url : imagelist.data[i],
                                                   mainImage : false,
                                                   idProduct : product.data.id
                                               });
                                        })
                                    }

                                }
                        })
                    })

                    //add product detail
                    $http.post("/api/product",{
                        price : $scope.form.price,
                        weight: $scope.form.weight,
                        discount : $scope.form.discount,
                        description: $scope.form.description,
                        idCategory : $scope.form.category,
                        idBrand : $scope.form.brand,
                        idDesign : $scope.form.design,
                        idProduct : product.data.id,
                        idHeelcushion : $scope.form.heelcushion,
                        idShoelace : $scope.form.shoelace,
                        idSole : $scope.form.sole,
                        idToe : $scope.form.toe
                    }).then(function (productdetail){
                     if (productdetail.status === 200){
                         //add material
                         let listMaterial = $scope.listMaterial;
                         for (let i = 0; i < listMaterial.length; i++) {
                             var checkMaterial = document.getElementById('Material'+listMaterial[i].id);
                             if (checkMaterial.checked == true){
                                 $http.post("/api/productdetail_material",{
                                     idProductDetail : productdetail.data.id,
                                     idMaterial : listMaterial[i].id
                                 });
                             }
                         }
                         // add size and color

                         let listColor = $scope.listColor;
                         let listSize = $scope.listSize;
                         for (let i = 0; i < listColor.length; i++) {
                             let color = document.getElementById('Color'+listColor[i].id);
                             if (color.checked == true){
                                 for (let j = 0; j < listSize.length; j++) {
                                     let quantity = document.getElementById('Color'+listColor[i].id + 'Size' + listSize[j].id).value;
                                     if (quantity > 0){
                                         $http.post("/api/productdetail_color_size",{
                                             idProductDetail: productdetail.data.id,
                                             idColor : listColor[i].id,
                                             idSize : listSize[j].id,
                                             quantity : quantity
                                         })
                                     }
                                 }
                             }
                         }

                     }

                        Swal.fire('Thêm thành công !', '', 'success')
                        setTimeout(() => {
                            location.href = "/admin/products/view";
                        }, 2000);
                    })


                }

            })


        }

        //delete product
        $scope.delete = function (idProductDetail){
            Swal.fire({
                title: 'Bạn có chắc muốn xóa ?',
                showCancelButton: true,
                confirmButtonText: 'Xóa',
            }).then((result) => {
                /* Read more about isConfirmed, isDenied below */
                if (result.isConfirmed) {
                    $http.put("/api/product/"+idProductDetail).then(function (response){
                        if (response.status === 200){
                            Swal.fire('Xóa thành công !', '', 'success')
                            setTimeout(() => {
                            location.href = "/admin/products/view";
                            }, 1500);
                        }
                    })

                }
            })
        }


        //detail product
        $scope.detail = function (){
            let id = document.getElementById("idProductDetail").value;
            $http.get("/api/product/"+id).then(function (detail){
                $scope.masanpham = detail.data.product.code,
                    $scope.tensanpham = detail.data.product.name,
                    $scope.trongluong = detail.data.weight,
                    $scope.giaban = detail.data.price,
                    $scope.giamgia = detail.data.discount,
                    $scope.mota = detail.data.description,
                    $scope.danhmuc = detail.data.category.id,
                    $scope.thuonghieu = detail.data.brand.id,
                    $scope.muigiay = detail.data.toe.id,
                    $scope.degiay = detail.data.sole.id,
                    $scope.daygiay = detail.data.shoelace.id,
                    $scope.lotgiay = detail.data.heelcushion.id
                    $scope.thietke = detail.data.design.id


                    for (let i = 0; i < detail.data.productDetail_materials.length; i++) {
                        document.getElementById('Material'+detail.data.productDetail_materials[i].material.id).checked = true;
                    }

                for (let i = 0; i < detail.data.productDetail_size_colors.length; i++) {
                    document.getElementById('Color'+detail.data.productDetail_size_colors[i].color.id).checked = true;
        }
                let listColor = $scope.listColor;
                for (let i = 0; i < listColor.length; i++) {
                    var checkBox = document.getElementById('Color' +listColor[i].id);
                    if (checkBox.checked == true){
                        $scope.checkbox(listColor[i].id);
                    }
                }
                for (let i = 0; i < detail.data.productDetail_size_colors.length; i++) {
                    document.getElementById('Color'+detail.data.productDetail_size_colors[i].color.id + 'Size'+detail.data.productDetail_size_colors[i].size.id).value = detail.data.productDetail_size_colors[i].quantity;

                }



            })
        }

        //update product
        $scope.update = function() {
            let id = document.getElementById("idProductDetail").value;
            // clear material and color size
            $http.delete("/api/productdetail_material/" + id);
            $http.delete("/api/productdetail_color_size/" + id)
            // update product detail
            $http.put("/api/product/update/" + id, {
                price: $scope.giaban,
                weight: $scope.trongluong,
                discount: $scope.giamgia,
                description: $scope.mota,
                idCategory: $scope.danhmuc,
                idBrand: $scope.thuonghieu,
                idDesign: $scope.thietke,
                idHeelcushion: $scope.lotgiay,
                idShoelace: $scope.daygiay,
                idSole: $scope.degiay,
                idToe: $scope.muigiay
            }).then(function (productDetail) {

                    //update product
                    $http.put("/api/sanpham/" + productDetail.data.product.id,{
                        name : $scope.tensanpham,
                        description : $scope.mota
                    }).then(function (product) {

                        // update image
                        var MainImage = document.getElementById("fileUpload").files;
                        if (MainImage.length > 0) {
                            $http.delete("/api/image/" + product.data.id)
                            var img = new FormData();
                            img.append("files", MainImage[0]);
                            $http.post("/api/upload", img, {
                                transformRequest: angular.identity,
                                headers: {
                                    'Content-Type': undefined
                                }
                            }).then(function (image) {
                                $http.post("/api/image", {
                                    url: image.data[0],
                                    mainImage: true,
                                    idProduct: product.data.id
                                })
                            })
                        }
                        var ListImage = document.getElementById("fileList").files;
                        if (ListImage.length > 0) {
                            $http.delete("/api/image/1/" + product.data.id);
                            var img1 = new FormData();
                            for (let i = 0; i < ListImage.length; i++) {
                                img1.append("files", ListImage[i]);
                                $http.post("/api/upload", img1, {
                                    transformRequest: angular.identity,
                                    headers: {
                                        'Content-Type': undefined
                                    }
                                }).then(function (imagelist) {
                                    $http.post("/api/image", {
                                        url: imagelist.data[i],
                                        mainImage: false,
                                        idProduct: product.data.id
                                    });
                                })
                            }

                        }
                    })
                //update material
                let listMaterial = $scope.listMaterial;
                for (let i = 0; i < listMaterial.length; i++) {
                    var checkMaterial = document.getElementById('Material'+listMaterial[i].id);
                    if (checkMaterial.checked == true){
                        $http.post("/api/productdetail_material",{
                            idProductDetail : productDetail.data.id,
                            idMaterial : listMaterial[i].id
                        });
                    }
                }

                        // update size and color

                        let listColor = $scope.listColor;
                        let listSize = $scope.listSize;
                        for (let i = 0; i < listColor.length; i++) {
                            let color = document.getElementById('Color' + listColor[i].id);
                            if (color.checked == true) {
                                for (let j = 0; j < listSize.length; j++) {
                                    let quantity = document.getElementById('Color' + listColor[i].id + 'Size' + listSize[j].id).value;
                                    if (quantity > 0) {
                                        $http.post("/api/productdetail_color_size", {
                                            idProductDetail: productDetail.data.id,
                                            idColor: listColor[i].id,
                                            idSize: listSize[j].id,
                                            quantity: quantity
                                        })
                                    }
                                }
                            }

                        }


                Swal.fire('Sửa thành công !', '', 'success')
                setTimeout(() => {
                    location.href = "/admin/products/view";
                }, 2000);




            })
        }
      // pagation
        $scope.pager = {
            page: 0,
            size: 5,
            get items() {
                var start = this.page * this.size;
                return $scope.list.slice(start, start + this.size);
            },
            get count() {
                return Math.ceil(1.0 * $scope.list.length / this.size);
            },

            first() {
                this.page = 0;
            },
            prev() {
                this.page--;
                if (this.page < 0) {
                    this.last();
                }
            },
            next() {
                this.page++;
                if (this.page >= this.count) {
                    this.first();
                }
            },
            last() {
                this.page = this.count - 1;
            }
        }

        //export exel
        $scope.exportData = function () {
            Swal.fire({
                title: 'Bạn có chắc muốn xuất Exel ?',
                showCancelButton: true,
                confirmButtonText: 'Xuất',
            }).then((result) => {
                /* Read more about isConfirmed, isDenied below */
                if (result.isConfirmed) {
                    $http.put("/api/product/"+idProductDetail).then(function (response){
                        if (response.status === 200){
                            Swal.fire('Xóa thành công !', '', 'success')
                            setTimeout(() => {
                                location.href = "/admin/products/view";
                            }, 1500);
                        }
                    })

                }
            })
        };


    })
