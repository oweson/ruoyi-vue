import request from '@/utils/request'

// 查询baby名字列表
export function listBabystudent(query) {
  return request({
    url: '/system/babystudent/list',
    method: 'get',
    params: query
  })
}

// 查询baby名字详细
export function getBabystudent(id) {
  return request({
    url: '/system/babystudent/' + id,
    method: 'get'
  })
}

// 新增baby名字
export function addBabystudent(data) {
  return request({
    url: '/system/babystudent',
    method: 'post',
    data: data
  })
}

// 修改baby名字
export function updateBabystudent(data) {
  return request({
    url: '/system/babystudent',
    method: 'put',
    data: data
  })
}

// 删除baby名字
export function delBabystudent(id) {
  return request({
    url: '/system/babystudent/' + id,
    method: 'delete'
  })
}

// 导出baby名字
export function exportBabystudent(query) {
  return request({
    url: '/system/babystudent/export',
    method: 'get',
    params: query
  })
}