import request from '@/utils/request'

// 查询码段归属列表
export function listMobile(query) {
  return request({
    url: '/system/mobile/list',
    method: 'get',
    params: query
  })
}

// 查询码段归属详细
export function getMobile(id) {
  return request({
    url: '/system/mobile/' + id,
    method: 'get'
  })
}

// 新增码段归属
export function addMobile(data) {
  return request({
    url: '/system/mobile',
    method: 'post',
    data: data
  })
}

// 修改码段归属
export function updateMobile(data) {
  return request({
    url: '/system/mobile',
    method: 'put',
    data: data
  })
}

// 删除码段归属
export function delMobile(id) {
  return request({
    url: '/system/mobile/' + id,
    method: 'delete'
  })
}

// 导出码段归属
export function exportMobile(query) {
  return request({
    url: '/system/mobile/export',
    method: 'get',
    params: query
  })
}