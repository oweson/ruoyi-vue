<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="手机号码段" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入手机号码段"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="省份" prop="province">
        <el-input
          v-model="queryParams.province"
          placeholder="请输入省份"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="市" prop="city">
        <el-input
          v-model="queryParams.city"
          placeholder="请输入市"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="运营商" prop="serviceProvider">
        <el-input
          v-model="queryParams.serviceProvider"
          placeholder="请输入运营商"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="区号" prop="cityCode">
        <el-input
          v-model="queryParams.cityCode"
          placeholder="请输入区号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮编" prop="postcode">
        <el-input
          v-model="queryParams.postcode"
          placeholder="请输入邮编"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:mobile:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:mobile:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:mobile:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:mobile:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="mobileList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="手机号码段" align="center" prop="phone" />
      <el-table-column label="省份" align="center" prop="province" />
      <el-table-column label="市" align="center" prop="city" />
      <el-table-column label="运营商" align="center" prop="serviceProvider" />
      <el-table-column label="区号" align="center" prop="cityCode" />
      <el-table-column label="邮编" align="center" prop="postcode" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:mobile:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:mobile:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改码段归属对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="手机号码段" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入手机号码段" />
        </el-form-item>
        <el-form-item label="省份" prop="province">
          <el-input v-model="form.province" placeholder="请输入省份" />
        </el-form-item>
        <el-form-item label="市" prop="city">
          <el-input v-model="form.city" placeholder="请输入市" />
        </el-form-item>
        <el-form-item label="运营商" prop="serviceProvider">
          <el-input v-model="form.serviceProvider" placeholder="请输入运营商" />
        </el-form-item>
        <el-form-item label="区号" prop="cityCode">
          <el-input v-model="form.cityCode" placeholder="请输入区号" />
        </el-form-item>
        <el-form-item label="邮编" prop="postcode">
          <el-input v-model="form.postcode" placeholder="请输入邮编" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listMobile, getMobile, delMobile, addMobile, updateMobile, exportMobile } from "@/api/system/mobile";

export default {
  name: "Mobile",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 码段归属表格数据
      mobileList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        phone: null,
        province: null,
        city: null,
        serviceProvider: null,
        cityCode: null,
        postcode: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        phone: [
          { required: true, message: "手机号码段不能为空", trigger: "blur" }
        ],
        province: [
          { required: true, message: "省份不能为空", trigger: "blur" }
        ],
        city: [
          { required: true, message: "市不能为空", trigger: "blur" }
        ],
        serviceProvider: [
          { required: true, message: "运营商不能为空", trigger: "blur" }
        ],
        cityCode: [
          { required: true, message: "区号不能为空", trigger: "blur" }
        ],
        postcode: [
          { required: true, message: "邮编不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询码段归属列表 */
    getList() {
      this.loading = true;
      listMobile(this.queryParams).then(response => {
        this.mobileList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        phone: null,
        province: null,
        city: null,
        serviceProvider: null,
        cityCode: null,
        postcode: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加码段归属";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getMobile(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改码段归属";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMobile(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMobile(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除码段归属编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delMobile(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有码段归属数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportMobile(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
