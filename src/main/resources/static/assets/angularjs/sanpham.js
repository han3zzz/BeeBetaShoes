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
       $scope.loadAll = function (){
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
       }
       $scope.loadAll();
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
                            text.innerHTML += '<span style="padding-left: 10px; padding-bottom: 10px">Size</span> '+listSize[j].name+ ' <input id="Color'+listColor[i].id+'Size'+listSize[j].id+'" type="number" value="0" style="width: 50px">';
                        }
                        text.innerHTML += '</div>';
                    } else {
                        text.innerHTML = '';
                    }
                }
            }

        };

        $scope.form = {
            product : {
                code : '',
                name : '',
                description : ''

            }
        };
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
            $scope.get = function (name){
                return document.getElementById(name).value;
            }
            //validate
            $http.post("/api/product/validate",{
                code : $scope.form.product.code,
                name : $scope.form.product.name,
                price : $scope.form.price,
                weight: $scope.form.weight,
                discount : $scope.form.discount,
                description : $scope.form.description
            }).then(function (vali){
                if (vali.status === 200){
                    //validate
                    $scope.validationErrors = [];
                    let indexMaterial = 0;
                    for (let i = 0; i < $scope.listMaterial.length; i++) {
                        let checkIndexMaterial = document.getElementById('Material'+$scope.listMaterial[i].id);
                        if (checkIndexMaterial.checked == true){
                           indexMaterial++;
                        }
                    }
                    let indexColor = 0;
                    for (let i = 0; i < $scope.listColor.length; i++) {
                        let checkIndexColor = document.getElementById('Color'+$scope.listColor[i].id);
                        if (checkIndexColor.checked == true){
                            indexColor++;
                        }
                    }
                    if (indexMaterial === 0){
                        Swal.fire('Vui lòng chọn ít nhất 1 chất liệu cho sản phẩm !', '', 'error');
                        return;
                    }
                    if (indexColor === 0){
                        Swal.fire('Vui lòng chọn ít nhất 1 màu sắc cho sản phẩm !', '', 'error');
                        return;
                    }
                    // check size and color

                    for (let i = 0; i < $scope.listColor.length; i++) {
                        let color = document.getElementById('Color'+$scope.listColor[i].id);
                        if (color.checked == true){
                            let iddexQuantity = 0;
                            for (let j = 0; j < $scope.listSize.length; j++) {
                                let quantity = document.getElementById('Color'+$scope.listColor[i].id + 'Size' + $scope.listSize[j].id).value;
                                if (quantity == 0){
                                    iddexQuantity++;
                                }
                                if (quantity < 0 || quantity > 999){
                                    Swal.fire('Số lượng size ' + $scope.listSize[j].name + ' màu '+$scope.listColor[i].name  +' phải lớn hơn bằng 0 và nhỏ hơn 999 !', '', 'error');
                                    return;
                                }
                                if (quantity.trim() === ''){
                                    Swal.fire('Số lượng size ' + $scope.listSize[j].name + ' màu '+$scope.listColor[i].name  +' không được bỏ trống !', '', 'error');
                                    document.getElementById('Color'+$scope.listColor[i].id + 'Size' + $scope.listSize[j].id).value = 0;
                                    return;
                                }
                            }
                            if (iddexQuantity === $scope.listSize.length){
                                Swal.fire('Vui lòng nhập số lượng kích thước tối thiểu cho màu '+$scope.listColor[i].name  +' !', '', 'error');
                                return;
                            }
                        }
                    }
                    $http.post("/api/sanpham",{
                        code : $scope.form.product.code,
                        name : $scope.form.product.name,
                        description : $scope.form.description,
                    }).then(function (product){
                        // if (product.status === 200){
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
                            idCategory : $scope.get("category"),
                            idBrand : $scope.get("brand"),
                            idDesign : $scope.get("design"),
                            idProduct : product.data.id,
                            idHeelcushion : $scope.get("heelcushion"),
                            idShoelace : $scope.get("shoelace"),
                            idSole : $scope.get("sole"),
                            idToe : $scope.get("toe")
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
                                Swal.fire('Thêm thành công !', '', 'success')
                                setTimeout(() => {
                                    location.href = "/admin/products/view";
                                }, 2000);
                            }



                        }).catch(function (error){
                            Swal.fire('Thêm thất bại !', '', 'error')
                        })


                        // }

                    })
                }
            }).catch(function (err){
                    if (err.status === 400){
                        $scope.validationErrors = err.data;
                    }
                if (err.status === 404){
                    Swal.fire('Mã sản phẩm đã tồn tại !', '', 'error')
                    $scope.validationErrors = [];
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
                        else{
                            Swal.fire('Xóa thất bại !', '', 'error')
                        }
                    })

                }
            })
        }


        //detail product
        $scope.detail = function (){
            let id = document.getElementById("idProductDetail").value;
            $http.get("/api/product/"+id).then(function (detail){
                $scope.form = detail.data;
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
            $scope.get = function (name){
                return document.getElementById(name).value;
            }
            //validate
            $http.post("/api/product/validateupdate",{
                code : $scope.form.product.code,
                name : $scope.form.product.name,
                price : $scope.form.price,
                weight: $scope.form.weight,
                discount : $scope.form.discount,
                description : $scope.form.description
            }).then(function (vali){
                if (vali.status === 200){
                    //validate
                    $scope.validationErrors = [];
                    let indexMaterial = 0;
                    for (let i = 0; i < $scope.listMaterial.length; i++) {
                        let checkIndexMaterial = document.getElementById('Material'+$scope.listMaterial[i].id);
                        if (checkIndexMaterial.checked == true){
                            indexMaterial++;
                        }
                    }
                    let indexColor = 0;
                    for (let i = 0; i < $scope.listColor.length; i++) {
                        let checkIndexColor = document.getElementById('Color'+$scope.listColor[i].id);
                        if (checkIndexColor.checked == true){
                            indexColor++;
                        }
                    }
                    if (indexMaterial === 0){
                        Swal.fire('Vui lòng chọn ít nhất 1 chất liệu cho sản phẩm !', '', 'error');
                        return;
                    }
                    if (indexColor === 0){
                        Swal.fire('Vui lòng chọn ít nhất 1 màu sắc cho sản phẩm !', '', 'error');
                        return;
                    }
                    // check size and color

                    for (let i = 0; i < $scope.listColor.length; i++) {
                        let color = document.getElementById('Color'+$scope.listColor[i].id);
                        if (color.checked == true){
                            let iddexQuantity = 0;
                            for (let j = 0; j < $scope.listSize.length; j++) {
                                let quantity = document.getElementById('Color'+$scope.listColor[i].id + 'Size' + $scope.listSize[j].id).value;
                                if (quantity == 0){
                                    iddexQuantity++;
                                }
                                if (quantity < 0 || quantity > 999){
                                    Swal.fire('Số lượng size ' + $scope.listSize[j].name + ' màu '+$scope.listColor[i].name  +' phải lớn hơn bằng 0 và nhỏ hơn 999 !', '', 'error');
                                    return;
                                }
                                if (quantity.trim() === ''){
                                    Swal.fire('Số lượng size ' + $scope.listSize[j].name + ' màu '+$scope.listColor[i].name  +' không được bỏ trống !', '', 'error');
                                    document.getElementById('Color'+$scope.listColor[i].id + 'Size' + $scope.listSize[j].id).value = 0;
                                    return;
                                }
                            }
                            if (iddexQuantity === $scope.listSize.length){
                                Swal.fire('Vui lòng nhập số lượng kích thước tối thiểu cho màu '+$scope.listColor[i].name  +' !', '', 'error');
                                return;
                            }
                        }
                    }
                    Swal.fire({
                        title: 'Bạn có chắc muốn sửa ?',
                        showCancelButton: true,
                        confirmButtonText: 'Sửa',
                    }).then((result) => {
                        /* Read more about isConfirmed, isDenied below */
                        if (result.isConfirmed) {
                            // clear material and color size
                            $http.delete("/api/productdetail_material/" + id);
                            $http.delete("/api/productdetail_color_size/" + id)
                            // update product detail
                            $http.put("/api/product/update/" + id, {
                                price: $scope.form.price,
                                weight: $scope.form.weight,
                                discount: $scope.form.discount,
                                description: $scope.form.description,
                                idCategory: $scope.get("category"),
                                idBrand: $scope.get("brand"),
                                idDesign: $scope.get("design"),
                                idHeelcushion: $scope.get("heelcushion"),
                                idShoelace: $scope.get("shoelace"),
                                idSole: $scope.get("sole"),
                                idToe: $scope.get("toe")
                            }).then(function (productDetail) {

                                //update product
                                $http.put("/api/sanpham/" + productDetail.data.product.id,{
                                    name : $scope.form.product.name,
                                    description : $scope.form.description
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





                            }).catch(function (error){
                                Swal.fire('Sửa thất bại !', '', 'error')
                            })
                        }
                    })
                }
            }).catch(function (err){
                if (err.status === 400){
                    $scope.validationErrors = err.data;
                }

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
        $scope.exportToExcel = function () {
            Swal.fire({
                title: 'Bạn có chắc muốn xuất Exel ?',
                showCancelButton: true,
                confirmButtonText: 'Xuất',
            }).then((result) => {
                if (result.isConfirmed){
                    // Chuyển dữ liệu thành một mảng các đối tượng JSON
                    var dataArray = $scope.list.map(function (item) {
                        var Materials = item.productDetail_materials.map(function (detail){
                            return detail.material.name;
                        }).join(', ');
                        var Images = item.product.productImages.map(function (image){
                            return image.url ;
                        }).join(', ');
                        var Color_Size = item.productDetail_size_colors.map(function (size){
                            return 'Color : ' + size.color.name + ' { Size ' + size.size.name + ' | Quantity : ' + size.quantity + '}';
                        }).join(', ');
                        return {
                            Code: item.product.code,
                            Name: item.product.name,
                            Images : Images,
                            Price : item.price,
                            Weight : item.weight,
                            Description : item.description,
                            Discount : item.discount,
                            Category : item.category.name,
                            Brand : item.brand.name,
                            Toe : item.toe.name,
                            Sole : item.sole.name,
                            Shoelcae : item.shoelace.name,
                            Heelcushion : item.heelcushion.name,
                            Materials :  Materials,
                            QuantityByColor_Sizes : Color_Size
                        };
                    });

                    // Tạo một workbook mới
                    var workbook = XLSX.utils.book_new();

                    // Tạo một worksheet từ dữ liệu
                    var worksheet = XLSX.utils.json_to_sheet(dataArray);

                    // Thêm worksheet vào workbook
                    XLSX.utils.book_append_sheet(workbook, worksheet, 'Data Sheet');

                    // Xuất tệp Excel
                    XLSX.writeFile(workbook, 'data'+ new Date()+'.xlsx');
                    Swal.fire("Xuất file exel thành công !","","success");
                }
            })

        }

        // search by name
        $scope.search = function (){
            var name = document.getElementById("name").value;
            if (name.trim().length === 0){
               Swal.fire("Nhập tên trước khi tìm kiếm...","","error");
            }
            else{
                $http.get("/api/product/search/"+name).then(function (search){
                    $scope.list = search.data;
                    $scope.pager.first();
                })
            }

        }

        //filter
        $scope.filter = function (){
            let idCategory = document.getElementById("danhmuc").value;
            let idMaterial = document.getElementById("chatlieu").value;
            let idColor = document.getElementById("mausac").value;
            let idSize = document.getElementById("kichthuoc").value;
            let idBrand = document.getElementById("thuonghieu").value;
            let idToe = document.getElementById("muigiay").value;
            let idSole = document.getElementById("degiay").value;
            let idShoelace = document.getElementById("daygiay").value;
            let idHeelcushion = document.getElementById("lotgiay").value;
            let idDesign = document.getElementById("thietke").value;
            let min = document.getElementById("rangeMin").value;
            let max = document.getElementById("rangeMax").value;
            let minTL = document.getElementById("rangeMinTL").value;
            let maxTL = document.getElementById("rangeMaxTL").value;
            let idcate = (idCategory != '') ? idCategory : null;
            let idbrad = (idBrand != '') ? idBrand : null;
            let idmate = (idMaterial != '') ? idMaterial : null;
            let idtoe = (idToe != '') ? idToe : null;
            let idsole = (idSole != '') ? idSole: null;
            let idcolor = (idColor != '') ? idColor : null;
            let idsize = (idSize != '') ? idSize : null;
            let idshoe = (idShoelace != '') ? idShoelace : null;
            let idheel = (idHeelcushion != '') ? idHeelcushion : null;
            let iddesign =(idDesign != '') ? idDesign : null;


            var params = {
                idcategory : idcate ,
                idmaterial : idmate,
                idcolor : idcolor,
                idsize : idsize,
                idbrand : idbrad,
                idtoe : idtoe,
                idsole : idsole,
                idshoelace : idshoe,
                idheelcushion : idheel,
                iddesign : iddesign,
                min : min,
                max : max,
                minTL : minTL,
                maxTL : maxTL
            }
            $http({
                method : 'GET',
                url : '/api/product/filter',
                params : params
            }).then(function (resp){
                $scope.list = resp.data;
                $scope.pager.first();
                Swal.fire("Lọc thành công !","","success");
            });
        }

        //import exel
        $scope.importExel = function (){
            Swal.fire("Đang phát triển...","","warning"); return;
            document.getElementById('fileInput').click();
            var reader = new FileReader();
            reader.onloadend = async () => { // => reader.result
                var workbook = new ExcelJS.Workbook();
                await workbook.xlsx.load(reader.result);
                const worksheet = workbook.getWorksheet('Sheet1');
                worksheet.eachRow((row, index) => {
                    if(index > 1){
                        let student = {
                            email: row.getCell(1).value,
                            fullname: row.getCell(2).value,
                            marks: +row.getCell(3).value,
                            gender: true && row.getCell(4).value,
                            country: row.getCell(5).value
                        }
                        var url = "http://localhost:8080/rest/students";
                        $http.post(url, student).then(resp => {
                            console.log("Success", resp.data);
                        }).catch(error => {
                            console.log("Error", error);
                        })
                    }
                });
            };
            reader.readAsArrayBuffer(files[0]);
        }


    })
