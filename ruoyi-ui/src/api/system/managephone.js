import request from '@/utils/request'

// 查询手机号码列表
export function listManagephone(query) {
  return request({
    url: '/system/managephone/list',
    method: 'get',
    params: query
  })
}

// 查询手机号码详细
export function getManagephone(id) {
  return request({
    url: '/system/managephone/' + id,
    method: 'get'
  })
}

// 新增手机号码
export function addManagephone(data) {
  return request({
    url: '/system/managephone',
    method: 'post',
    data: data
  })
}

// 修改手机号码
export function updateManagephone(data) {
  return request({
    url: '/system/managephone',
    method: 'put',
    data: data
  })
}

// 删除手机号码
export function delManagephone(id) {
  return request({
    url: '/system/managephone/' + id,
    method: 'delete'
  })
}

// 导出手机号码
export function exportManagephone(query) {
  return request({
    url: '/system/managephone/export',
    method: 'get',
    params: query
  })
}